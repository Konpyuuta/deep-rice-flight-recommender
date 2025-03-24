package org.example.deeprice.model;

import org.example.deeprice.model.rating.AirlineRating;

/**
 *
 * @author Maurice Amon
 */

public class Airline {

    private String identifier;

    private String name;

    private AirlineRating airlineRating;

    public Airline(String identifier, String name, AirlineRating airlineRating) {
        this.identifier = identifier;
        this.name = name;
        this.airlineRating = airlineRating;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AirlineRating getAirlineRating() {
        return airlineRating;
    }

    public void setAirlineRating(AirlineRating airlineRating) {
        this.airlineRating = airlineRating;
    }



}
