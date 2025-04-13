package org.example.deeprice.model.result;

import org.example.deeprice.model.Airport;

/**
 *
 * @author Maurice Amon
 */

public class FlightOffer {

    private String flightID;

    private Airport originAirport;

    private Airport destinationAirport;

    private String departureDate;

    public FlightOffer(String flightID, Airport originAirport, Airport destinationAirport, String departureDate) {
        this.flightID = flightID;
        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
        this.departureDate = departureDate;
    }

    public Airport getOriginAirport() {
        return originAirport;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    @Override
    public String toString() {
        return flightID + ": From: " + originAirport.getAirportID() + " To: " + destinationAirport.getAirportID();
    }
}
