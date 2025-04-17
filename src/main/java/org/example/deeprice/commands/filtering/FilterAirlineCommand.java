package org.example.deeprice.commands.filtering;

import org.example.deeprice.commands.Command;
import org.example.deeprice.model.graphdb.GraphDBConnector;
import org.example.deeprice.model.result.flight.Flight;
import org.example.deeprice.model.result.flight.FlightItinerary;
import org.example.deeprice.model.result.flight.FlightJourney;
import org.example.deeprice.model.result.flight.Results;
import org.neo4j.driver.Record;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maurice Amon
 */

public class FilterAirlineCommand implements Command {

    private List<String> airlines;

    public FilterAirlineCommand(List<String> airlines) {
        this.airlines = airlines;
    }

    @Override
    public void execute() {
        List<FlightJourney> flightJourneys = Results.FLIGHT_JOURNEY_LIST;
        for(FlightJourney flightJourney : flightJourneys) {
            for(FlightItinerary itinerary : flightJourney.getFlightItineraries()) {
                for(Flight flight : itinerary.getFlights()) {
                    if(!airlines.contains(flight.getCarrierCode())) {
                        flightJourneys.remove(flightJourney);
                    }
                }
            }
        }
    }
}
