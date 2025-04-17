package org.example.deeprice.model.result.flight;

import org.example.deeprice.model.Airport;

/**
 *
 * @author Maurice Amon
 */

public class Flight {

    private Airport departureAirport;

    private Airport arrivalAirport;

    private String departureTime;

    private String arrivalTime;

    private String carrierCode;

    private String flightId;

    public Flight(Airport departureAirport, Airport arrivalAirport, String departureTime, String arrivalTime, String carrierCode, String flightId) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.carrierCode = carrierCode;
        this.flightId = flightId;
    }

    public Flight() {

    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getCarrierCode() {
        return carrierCode;
    }

    public String getFlightId() {
        return flightId;
    }

    public String toString() {
        return "Origin Airport: " + departureAirport.getAirportID() + "; Destination ariport" + arrivalAirport.getAirportID() + "; Departure Time: " + departureTime + "; Arrival Time: " + arrivalTime;
    }
}
