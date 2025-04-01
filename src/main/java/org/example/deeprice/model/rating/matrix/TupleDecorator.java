package org.example.deeprice.model.rating.matrix;

/**
 *
 * @author Maurice Amon
 */

public abstract class TupleDecorator extends RatingTuple {

    private final RatingTuple ratingTuple;

    public TupleDecorator(RatingTuple ratingTuple) {
        this.ratingTuple = ratingTuple;
    }

    @Override
    public void setEntries() {
        ratingTuple.setEntries();
    }

    public Float[] getRatingTuple() {
        return ratingTuple.getRatingTuple();
    }
}
