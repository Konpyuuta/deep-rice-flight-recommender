package org.example.deeprice.model.rating.matrix;

/**
 *
 * @author Maurice Amon
 */

public abstract class RatingTuple {

    protected Float[] tuple;

    protected Integer counter;

    protected abstract void setEntries();

    public abstract Float[] getRatingTuple();
}
