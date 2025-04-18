package org.example.deeprice.model.result.flight;

/**
 *
 * @author Maurice Amon
 */

public class AllowedLuggage {

    private Integer quantity;

    private Integer weight;

    private String unit;

    public AllowedLuggage(Integer quantity, Integer weight, String unit) {
        this.quantity = quantity;
        this.weight = weight;
        this.unit = unit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getUnit() {
        return unit;
    }
}
