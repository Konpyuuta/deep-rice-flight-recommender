package org.example.deeprice.model;

import org.example.deeprice.model.rating.AirportRating;

/**
 *
 *
 * @author Maurice Amon
 */

public class Airport {

    private String airportID;

    private String airportName;

    private AirportRating airportRating;

    public Airport(String airportID, String airportName, AirportRating airportRating) {
        this.airportID = airportID;
        this.airportName = airportName;
        this.airportRating = airportRating;
    }

    public Airport(String airportID) {
        this.airportID = airportID;
    }

    public String getAirportID() {
        return airportID;
    }

    public void setAirportID(String airportID) {
        this.airportID = airportID;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public AirportRating getAirportRating() {
        return airportRating;
    }

    public void setAirportRating(AirportRating airportRating) {
        this.airportRating = airportRating;
    }

}
