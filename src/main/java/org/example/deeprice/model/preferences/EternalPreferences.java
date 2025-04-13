package org.example.deeprice.model.preferences;

import org.example.deeprice.model.user.criteria.Height;

/**
 *
 * @author Maurice Amon
 */

public class EternalPreferences {

    private Height height;

    private Double foodPreference;

    private static EternalPreferences instance;

    private EternalPreferences() {

    }

    public static EternalPreferences getInstance() {
        if (instance == null) {
            instance = new EternalPreferences();
        }
        return instance;
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

    public void destroyInstance() {
        instance = null;
    }
}
