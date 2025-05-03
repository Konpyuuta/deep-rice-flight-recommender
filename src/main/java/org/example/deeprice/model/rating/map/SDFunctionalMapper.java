package org.example.deeprice.model.rating.map;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Maurice Amon
 */

public class SDFunctionalMapper {

    private static Map<RatingKey, Double> ratingFunctionMap = new HashMap<RatingKey, Double>();

    static {
        ratingFunctionMap.put(new RatingKey(1.0, -2.0), 0.0);
        ratingFunctionMap.put(new RatingKey(1.0, -1.0), 0.0);
        ratingFunctionMap.put(new RatingKey(1.0, 0.0), 0.0);
        ratingFunctionMap.put(new RatingKey(1.0, 1.0), 0.0);
        ratingFunctionMap.put(new RatingKey(1.0, 2.0), 0.0);

        ratingFunctionMap.put(new RatingKey(2.0, -2.0), -0.2);
        ratingFunctionMap.put(new RatingKey(2.0, -1.0), 0.0);
        ratingFunctionMap.put(new RatingKey(2.0, 0.0), 0.0);
        ratingFunctionMap.put(new RatingKey(2.0, 1.0), 0.2);
        ratingFunctionMap.put(new RatingKey(2.0, 2.0), 0.4);

        ratingFunctionMap.put(new RatingKey(3.0, -2.0), -0.6);
        ratingFunctionMap.put(new RatingKey(3.0, -1.0), -0.4);
        ratingFunctionMap.put(new RatingKey(3.0, 0.0), 0.0);
        ratingFunctionMap.put(new RatingKey(3.0, 1.0), 0.4);
        ratingFunctionMap.put(new RatingKey(3.0, 2.0), 0.6);

        ratingFunctionMap.put(new RatingKey(4.0, -2.0), -0.8);
        ratingFunctionMap.put(new RatingKey(4.0, -1.0), -0.6);
        ratingFunctionMap.put(new RatingKey(4.0, 0.0), -0.2);
        ratingFunctionMap.put(new RatingKey(4.0, 1.0), 0.6);
        ratingFunctionMap.put(new RatingKey(4.0, 2.0), 0.8);

        ratingFunctionMap.put(new RatingKey(5.0, -2.0), -1.0);
        ratingFunctionMap.put(new RatingKey(5.0, -1.0), -0.8);
        ratingFunctionMap.put(new RatingKey(5.0, 0.0), -0.4);
        ratingFunctionMap.put(new RatingKey(5.0, 1.0), 0.8);
        ratingFunctionMap.put(new RatingKey(5.0, 2.0), 1.0);



    }

    public static Map<RatingKey, Double> getRatingFunctionMap() {
        return ratingFunctionMap;
    }
}
