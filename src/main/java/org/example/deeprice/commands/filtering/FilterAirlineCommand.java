package org.example.deeprice.commands.filtering;

import org.example.deeprice.commands.Command;
import org.example.deeprice.model.graphdb.GraphDBConnector;
import org.example.deeprice.model.result.flight.Flight;
import org.example.deeprice.model.result.flight.FlightItinerary;
import org.example.deeprice.model.result.flight.FlightJourney;
import org.example.deeprice.model.result.flight.Results;
import org.example.deeprice.model.user.User;
import org.neo4j.driver.Record;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maurice Amon
 */

public class FilterAirlineCommand implements Command {

    private List<String> airlines;

    private Integer weight;

    public FilterAirlineCommand(List<String> airlines, Integer weight) {
        this.airlines = airlines;
        this.weight = weight;
    }

    @Override
    public void execute() {
        List<FlightJourney> flightJourneys = Results.getFlightJourneyList();
        List<FlightJourney> newList = new ArrayList<>();
        for(FlightJourney flightJourney : flightJourneys) {
            for (FlightItinerary itinerary : flightJourney.getFlightItineraries()) {
                Boolean isValid = true;
                for (Flight flight : itinerary.getFlights()) {
                    if (airlines.contains(flight.getCarrierCode()) && flightJourney.getAllowedLuggage().getWeight() <= weight) {

                    } else {
                        isValid = false;
                    }
                }
                if (isValid) {
                    newList.add(flightJourney);
                }
            }

        }
        Results.setFlightJourneyList(newList);
    }
}
