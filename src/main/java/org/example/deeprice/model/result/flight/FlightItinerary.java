package org.example.deeprice.model.result.flight;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maurice Amon
 */

public class FlightItinerary {

    private List<Flight> flights = new ArrayList<>();

    private Boolean hasLayover;

    public FlightItinerary() {

    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setHasLayover(Boolean hasLayover) {
        this.hasLayover = hasLayover;
    }

    public Boolean getHasLayover() {
        return hasLayover;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Flight flight : flights) {
            sb.append(flight);
        }
        return sb.toString();
    }
}
