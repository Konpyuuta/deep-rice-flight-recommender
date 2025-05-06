package org.example.deeprice.model.preferences;

import org.example.deeprice.model.Airport;

/**
 *
 * @author Maurice Amon
 */

public class FlightPreferences {

    private Airport originAirport;

    private Airport destinationAirport;

    private String departureDateTime;

    private Integer adults;

    private Boolean isDirectFlight = Boolean.FALSE;

    private String flightClass;

    private static FlightPreferences instance;


    private FlightPreferences() {

    }

    public static FlightPreferences getInstance() {
        if (instance == null) {
            instance = new FlightPreferences();
        }
        return instance;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        String f;
        switch (flightClass) {
            case "Economy":
                f = "ECONOMY";
                break;
            case "Business":
                f = "BUSINESS";
                break;
            default:
                f = "FIRST";
        }
        this.flightClass = f;
    }

    public Airport getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(Airport originAirport) {
        this.originAirport = originAirport;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public String getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(String departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public Integer getAdults() {
        return adults;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    public Boolean getIsDirectFlight() {
        return isDirectFlight;
    }

    public void setIsDirectFlight(Boolean isDirectFlight) {
        this.isDirectFlight = isDirectFlight;
    }

    public void destroyInstance() {
        instance = null;
    }
}
