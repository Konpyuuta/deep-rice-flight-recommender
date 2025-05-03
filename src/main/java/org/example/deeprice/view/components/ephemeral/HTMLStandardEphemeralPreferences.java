package org.example.deeprice.view.components.ephemeral;

import org.example.deeprice.ProjectConstants;
import org.example.deeprice.model.graphdb.GraphDBConnector;
import org.example.deeprice.model.result.flight.Flight;
import org.example.deeprice.model.result.flight.FlightItinerary;
import org.example.deeprice.model.result.flight.FlightJourney;
import org.example.deeprice.model.result.flight.Results;
import org.neo4j.driver.Record;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Maurice Amon
 */

public class HTMLStandardEphemeralPreferences extends HTMLEphemeralPreferences {

    private Map<String, String> airlines;

    public HTMLStandardEphemeralPreferences() {
        airlines = extractValableAirlines();
        initializeContent();
    }

    @Override
    protected void initializeContent() {
        content = "<div class=\"container py-5\"><nav aria-label=\"breadcrumb\">\n" +
                "  <ol class=\"breadcrumb\">\n" +
                "    <li class=\"breadcrumb-item\" aria-current=\"page\">" + ProjectConstants.ETERNAL_PREF_NAV + "</li>\n" +
                "    <li class=\"breadcrumb-item\" aria-current=\"page\">Eternal Preferences</li>\n" +
                "    <li class=\"breadcrumb-item\" aria-current=\"page\">Choose Flight</li>\n" +
                "    <li class=\"breadcrumb-item active\" aria-current=\"page\">Ephemeral Preferences</li>   " +
                "  </ol>\n" +
                "</nav></div><h1 class=\"text-center\">Ephemeral Preferences</h1>\n" +
                "<div class=\"container py-5 bg-light\" style=\"border-radius: 15px;\"><form action=\"/ranking\" method=\"post\">\n" +
                "    <label for=\"luggage-weight\" class=\"form-label\">How much does your luggage weight?</label>\n" +
                "    <div class=\"input-group mb-3\">\n" +
                "        <div class=\"input-group-prepend\">\n" +
                "            <button class=\"btn btn-outline-secondary dropdown-toggle\" id=\"luggage-weight\" type=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">In Kg</button>\n" +
                "            <div class=\"dropdown-menu\">\n" +
                "                <a class=\"dropdown-item\" href=\"#\">In Lb</a>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <input type=\"text\" name=\"luggageWeight\" class=\"form-control\" aria-label=\"Your height with different metric options\">\n" +
                "    </div>\n" +
                "    <br>\n" +
                "    <label class=\"form-label\">Are there Airlines you don't want to fly with? If so, deselect them.</label>\n";
        for(Map.Entry entry : airlines.entrySet()) {
            content +="<div class=\"form-check\">\n" +
                    "     <input class=\"form-check-input\" type=\"checkbox\" name=\"prefAirlines\" value=\"" + entry.getKey().toString() + "\" id=\"" + entry.getKey().toString() + "\" checked>\n" +
                    "     <label class=\"form-check-label\" for=\"flexCheckCheckedDisabled\">\n" +
                                entry.getValue() + "\n" +
                    "     </label>\n" +
                    "</div>\n";
        }


            content += "<br>\n" +
                "    <hr/>\n" +
                "    <br>\n" +
                "    <button type=\"submit\" class=\"btn btn-primary\">Save preferences</button>\n" +
                "</form></div>";
    }

    private Map<String, String> extractValableAirlines() {
        GraphDBConnector graphDBConnector = GraphDBConnector.getInstance();
        Map<String, String> airlines = new HashMap<>();
        List<FlightJourney> flightJourneys = Results.getFlightJourneyList();
        for(FlightJourney flightJourney : flightJourneys) {
            for(FlightItinerary itinerary : flightJourney.getFlightItineraries()) {
                for(Flight flight : itinerary.getFlights()) {
                    ArrayList<Record> records = graphDBConnector.executeQuery("Match (n) Where n.iata = '" + flight.getCarrierCode() + "' return n.name");
                    for(Record record : records) {
                        if(!airlines.keySet().contains(flight.getCarrierCode())) {
                            airlines.put(flight.getCarrierCode(), record.get("n.name").asString());
                        }
                    }
                }
            }
        }
        return airlines;
    }
}
