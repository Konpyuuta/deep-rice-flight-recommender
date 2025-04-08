package org.example.deeprice.model.rating.matrix;

import org.example.deeprice.model.rating.AirlineRating;
import org.example.deeprice.model.rating.AirportRating;

/**
 *
 * @author Maurice
 */

public class StandardTuple extends RatingTuple {
    private AirlineRating airlineRating;

    private AirportRating airportRating;

    public StandardTuple(AirlineRating airlineRating, AirportRating airportRating) {
        this.airlineRating = airlineRating;
        this.airportRating = airportRating;
    }

    /**
     *
     */
    @Override
    protected void setEntries() {
        tuple[0] = Float.valueOf((float)airlineRating.getStaffFriendliness());
        tuple[1] = Float.valueOf((float)airportRating.getComfortability());
        tuple[2] = Float.valueOf((float)airportRating.getCleanilessness());
        tuple[3] = Float.valueOf((float)airlineRating.getStaffFriendliness());
        tuple[4] = Float.valueOf((float)airportRating.getComfortability());
        tuple[5] = Float.valueOf((float)airportRating.getCleanilessness());
        counter = 6;
    }

    public Float[] getRatingTuple() {
        return tuple;
    }
}
