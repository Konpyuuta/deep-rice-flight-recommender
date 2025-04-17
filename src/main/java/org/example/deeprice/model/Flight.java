package org.example.deeprice.model;

/**
 *
 *
 * @author Maurice Amon
 */

public class Flight {

    private String flightID;

    private Airline airline;

    private Airport startAirport;

    private Airport endAirport;

    public Flight(String flightID, Airline airline, Airport startAirport, Airport endAirport) {
        this.flightID = flightID;
        this.airline = airline;
        this.startAirport = startAirport;
        this.endAirport = endAirport;
    }

    public Flight() {

    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Airport getStartAirport() {
        return startAirport;
    }

    public void setStartAirport(Airport startAirport) {
        this.startAirport = startAirport;
    }

    public Airport getEndAirport() {
        return endAirport;
    }

    public void setEndAirport(Airport endAirport) {
        this.endAirport = endAirport;
    }
}
