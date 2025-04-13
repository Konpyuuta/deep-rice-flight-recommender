package org.example.deeprice.commands.api;

import org.example.deeprice.commands.Command;
import org.example.deeprice.model.Airport;
import org.example.deeprice.model.result.APIFlightResponse;
import org.example.deeprice.model.result.FlightOffer;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Maurice Amon
 */

public class ParseAPIResponseCommand implements Command {

    private String jsonFile;

    public ParseAPIResponseCommand(String jsonFile) {
        this.jsonFile = jsonFile;
    }

    @Override
    public void execute() {
        JSONObject obj = new JSONObject(jsonFile);
        JSONArray flightArray = obj.getJSONArray("data");

        APIFlightResponse apiFlightResponse = APIFlightResponse.getInstance();

        for(int i = 0; i < flightArray.length(); i++) {
            JSONObject flight = flightArray.getJSONObject(i);
            for(int j = 0; j < flight.getJSONArray("itineraries").length(); j++) {
                JSONObject itinerary = flight.getJSONArray("itineraries").getJSONObject(j);
                JSONArray segments = itinerary.getJSONArray("segments");
                for(int k = 0; k < segments.length(); k++) {
                    JSONObject segment = segments.getJSONObject(k);
                    JSONObject departure = segment.getJSONObject("departure");
                    JSONObject arrival = segment.getJSONObject("arrival");
                    String flightNumber = segment.getString("number");
                    FlightOffer flightOffer = new FlightOffer(flightNumber, new Airport(departure.getString("iataCode")), new Airport(arrival.getString("iataCode")), departure.getString("at"));
                    apiFlightResponse.addFlightOffer(flightOffer);
                }
            }
        }
    }


}
