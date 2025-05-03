package org.example.deeprice.model.preferences;

import org.example.deeprice.model.user.criteria.Height;

/**
 *
 * @author Maurice Amon
 */

public class EternalPreferences {

    private Height height;

    private Double foodPreference;

    private Double seatComfortabilityPreference;

    private Double customerServicePreference;

    private Double flightTimePreference;

    private Double pricePreference;

    private static EternalPreferences instance;

    private EternalPreferences() {

    }

    public static EternalPreferences getInstance() {
        if (instance == null) {
            instance = new EternalPreferences();
        }
        return instance;
    }

    public void setPricePreference(Double pricePreference) {
        this.pricePreference = pricePreference;
    }

    public Double getPricePreference() {
        return pricePreference;
    }

    public Height getHeight() {
        return height;
    }

    public void setHeight(Height height) {
        this.height = height;
    }

    public Double getFoodPreference() {
        return foodPreference;
    }

    public void setFoodPreference(Double foodPreference) {
        this.foodPreference = foodPreference;
    }

    public Double getSeatComfortabilityPreference() {
        return seatComfortabilityPreference;
    }
    public void setSeatComfortabilityPreference(Double seatComfortabilityPreference) {
        this.seatComfortabilityPreference = seatComfortabilityPreference;
    }

    public Double getCustomerServicePreference() {
        return customerServicePreference;
    }

    public void setCustomerServicePreference(Double customerServicePreference) {
        this.customerServicePreference = customerServicePreference;
    }

    public Double getFlightTimePreference() {
        return flightTimePreference;
    }

    public void setFlightTimePreference(Double flightTimePreference) {
        this.flightTimePreference = flightTimePreference;
    }

    public void destroyInstance() {
        instance = null;
    }
}
