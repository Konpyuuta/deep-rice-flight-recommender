package org.example.deeprice.model.rating.matrix;

/**
 *
 *
 * @author Maurice Amon
 */

public class UserPreferenceTuple extends RatingTuple {

    private Float[] userPreferences;

    public UserPreferenceTuple() {

    }

    @Override
    protected void setEntries() {

    }

    @Override
    public Float[] getRatingTuple() {
        return userPreferences;
    }
}
