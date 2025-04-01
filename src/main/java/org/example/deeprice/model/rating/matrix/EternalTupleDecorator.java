package org.example.deeprice.model.rating.matrix;

import org.example.deeprice.model.user.EternalPreferences;

/**
 *
 * @author Maurice Amon
 */

public class EternalTupleDecorator extends TupleDecorator {

    private EternalPreferences eternalPreferences;

    public EternalTupleDecorator(RatingTuple ratingTuple, EternalPreferences eternalPreferences) {
        super(ratingTuple);
        this.eternalPreferences = eternalPreferences;
    }

    @Override
    public void setEntries() {
        super.setEntries();
        tuple[counter++] = (float)eternalPreferences.getHeight().getHeight();
    }

    public Float[] getRatingTuple() {
        return super.getRatingTuple();
    }

}
