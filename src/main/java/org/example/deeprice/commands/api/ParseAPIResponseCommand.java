package org.example.deeprice.commands.api;

import org.example.deeprice.commands.Command;
import org.example.deeprice.model.AirlinesMap;
import org.example.deeprice.model.Airport;
import org.example.deeprice.model.result.APIFlightResponse;
import org.example.deeprice.model.result.FlightOffer;
import org.example.deeprice.model.result.flight.AllowedLuggage;
import org.example.deeprice.model.result.flight.Flight;
import org.example.deeprice.model.result.flight.FlightItinerary;
import org.example.deeprice.model.result.flight.FlightJourney;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maurice Amon
 */

public class ParseAPIResponseCommand implements Command {

    private String jsonFile;

    private List<FlightJourney> flightJourneys;

    private DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

    public ParseAPIResponseCommand(String jsonFile) {
        this.jsonFile = jsonFile;
    }

    @Override
    public void execute() {
        flightJourneys = new ArrayList<FlightJourney>();

        JSONObject obj = new JSONObject(jsonFile);
        JSONArray flightArray = obj.getJSONArray("data");
        JSONObject carriers = obj.getJSONObject("dictionaries").getJSONObject("carriers");
        for(String carrierCode : carriers.keySet()) {
            AirlinesMap.IATA_AIRLINES_MAP.put(carrierCode, carriers.getString(carrierCode));
        }
        APIFlightResponse apiFlightResponse = APIFlightResponse.getInstance();

        for(int i = 0; i < flightArray.length(); i++) {
            JSONObject flight = flightArray.getJSONObject(i);
            FlightJourney journey = new FlightJourney();
            Duration totalDuration = Duration.ZERO;
            journey.setJourneyId(flight.getString("id"));
            journey.setPrice(flight.getJSONObject("price").getDouble("total"));
            JSONArray itineraries = flight.getJSONArray("itineraries");
            for(int j = 0; j < itineraries.length(); j++) {
                JSONObject itinerary = itineraries.getJSONObject(j);
                JSONArray segments = itinerary.getJSONArray("segments");
                FlightItinerary flightItinerary = new FlightItinerary();
                for(int k = 0; k < segments.length(); k++) {
                    JSONObject segment = segments.getJSONObject(k);
                    Flight flightSegment = new Flight();
                    flightSegment.setDepartureAirport(new Airport(segment.getJSONObject("departure").getString("iataCode")));
                    flightSegment.setArrivalAirport(new Airport(segment.getJSONObject("arrival").getString("iataCode")));
                    flightSegment.setDepartureTime(segment.getJSONObject("departure").getString("at"));
                    flightSegment.setArrivalTime(segment.getJSONObject("arrival").getString("at"));
                    LocalDateTime arrTime = LocalDateTime.parse(segment.getJSONObject("arrival").getString("at"), formatter);
                    LocalDateTime depTime = LocalDateTime.parse(segment.getJSONObject("departure").getString("at"), formatter);
                    Duration segmentDuration = Duration.between(arrTime, depTime);
                    totalDuration.plus(segmentDuration);
                    flightSegment.setCarrierCode(segment.getString("carrierCode"));
                    flightSegment.setFlightId(segment.getString("number"));
                    flightItinerary.addFlight(flightSegment);
                }
                flightItinerary.setHasLayover(flightItinerary.getFlights().size() > 1);
                journey.addFlightItinerary(flightItinerary);
                journey.setTotalJourneyTime((double)totalDuration.toHours());

            }
            JSONArray travelerPricings = flight.getJSONArray("travelerPricings");
            for(int h = 0; h < travelerPricings.length(); h++) {
                JSONObject travelerPricing = travelerPricings.getJSONObject(h);
                JSONArray fareDetails = travelerPricing.getJSONArray("fareDetailsBySegment");
                for(int l = 0; l < fareDetails.length(); l++) {
                    JSONObject fareDetail = fareDetails.getJSONObject(l);
                    JSONObject bags = fareDetail.getJSONObject("includedCheckedBags");
                    Integer quantity = bags.optInt("quantity", 0);
                    Integer weight = bags.optInt("weight", -1);
                    String unit = bags.optString("weightUnit", "N/A");
                    AllowedLuggage allowedLuggage = new AllowedLuggage(quantity, weight, unit);
                    journey.setAllowedLuggage(allowedLuggage);
                }
            }
            flightJourneys.add(journey);
        }
    }

    public List<FlightJourney> getFlightJourneys() {
        return flightJourneys;
    }



}
