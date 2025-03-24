package org.example.deeprice.model.user.criteria;

/**
 *
 *
 * @author Maurice Amon
 */

public class Height {

    private Integer height;

    private String measure = "cm";

    public Height(Integer height) {
        this.height = height;
    }

    public Integer getHeight() {
        return height;
    }

}
