package org.example.deeprice.model.rating.map;

import java.util.Objects;

/**
 *
 * @author Maurice Amon
 */

public class RatingKey {

    private Double userRating;

    private Double systemRating;

    public RatingKey(Double userRating, Double systemRating) {
        this.userRating = userRating;
        this.systemRating = systemRating;
    }

    public Double getUserRating() {
        return userRating;
    }

    public Double getSystemRating() {
        return systemRating;
    }

    @Override
    public boolean equals(Object ratingKey) {
        RatingKey otherKey = (RatingKey) ratingKey;
        if(this == otherKey || (userRating == otherKey.userRating && systemRating == otherKey.systemRating)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userRating, systemRating);
    }
}
