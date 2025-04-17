package org.example.deeprice.commands.api;

import org.example.deeprice.commands.Command;
import org.example.deeprice.model.Airport;
import org.example.deeprice.model.result.APIFlightResponse;
import org.example.deeprice.model.result.FlightOffer;
import org.example.deeprice.model.result.flight.Flight;
import org.example.deeprice.model.result.flight.FlightItinerary;
import org.example.deeprice.model.result.flight.FlightJourney;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maurice Amon
 */

public class ParseAPIResponseCommand implements Command {

    private String jsonFile;

    private List<FlightJourney> flightJourneys;

    public ParseAPIResponseCommand(String jsonFile) {
        this.jsonFile = jsonFile;
    }

    @Override
    public void execute() {
        flightJourneys = new ArrayList<FlightJourney>();

        JSONObject obj = new JSONObject(jsonFile);
        JSONArray flightArray = obj.getJSONArray("data");

        APIFlightResponse apiFlightResponse = APIFlightResponse.getInstance();

        for(int i = 0; i < flightArray.length(); i++) {
            JSONObject flight = flightArray.getJSONObject(i);
            FlightJourney journey = new FlightJourney();
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
                    flightSegment.setCarrierCode(segment.getString("carrierCode"));
                    flightSegment.setFlightId(segment.getString("number"));
                    flightItinerary.addFlight(flightSegment);
                }
                flightItinerary.setHasLayover(flightItinerary.getFlights().size() > 1);
                journey.addFlightItinerary(flightItinerary);

            }
            flightJourneys.add(journey);
        }
    }

    public List<FlightJourney> getFlightJourneys() {
        return flightJourneys;
    }


}
