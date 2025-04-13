package org.example.deeprice.model.preferences;

import org.example.deeprice.model.Airline;

import java.util.List;

/**
 *
 * @author Maurice Amon
 */

public class EphemeralPreferences {

    private Double luggageWeight;

    private List<Airline> prefferedAirlines;

    private static EphemeralPreferences instance;

    private EphemeralPreferences() {

    }

    public static EphemeralPreferences getInstance() {
        if (instance == null) {
            instance = new EphemeralPreferences();
        }
        return instance;
    }

    public Double getLuggageWeight() {
        return luggageWeight;
    }

    public void setLuggageWeight(Double luggageWeight) {
        this.luggageWeight = luggageWeight;
    }

    public List<Airline> getPrefferedAirlines() {
        return prefferedAirlines;
    }

    public void setPrefferedAirlines(List<Airline> prefferedAirlines) {
        this.prefferedAirlines = prefferedAirlines;
    }

    public void destroyInstance() {
        instance = null;
    }
}
