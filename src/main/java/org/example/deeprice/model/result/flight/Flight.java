package org.example.deeprice.model.result.flight;

import org.example.deeprice.model.Airport;

import java.time.LocalDateTime;

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

    private Double[] ratings;

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

    public void setRatings(Double[] ratings) {
        this.ratings = ratings;
    }

    public Double[] getRatings() {
        return ratings;
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
        return LocalDateTime.parse(departureTime).toLocalTime().toString();
    }

    public String getArrivalTime() {
        return LocalDateTime.parse(arrivalTime).toLocalTime().toString();
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
