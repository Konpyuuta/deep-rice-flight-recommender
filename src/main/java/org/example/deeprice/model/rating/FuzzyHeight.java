package org.example.deeprice.model.rating;

import org.example.deeprice.model.user.criteria.Height;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Maurice Amon
 */

public class FuzzyHeight {

    private Height height;

    private Map<Height, Double[]> fuzzyMap = new HashMap<Height, Double[]>();

    public FuzzyHeight(Height height) {
        this.height = height;
        initializeFuzzyMap();
    }

    private void initializeFuzzyMap() {
        Double small = initializeSmallDegree();
        Double mid = initializeMidDegree();
        Double large = initializeLargeDegree();
        Double[] fuzzyArray = new Double[3];
        fuzzyArray[0] = small;
        fuzzyArray[1] = mid;
        fuzzyArray[2] = large;
        fuzzyMap.put(height, fuzzyArray);
    }

    private Double initializeSmallDegree() {
        Double smallDegree;
        if(height.getHeight() < 150) {
            smallDegree = 1.0;
        } else if(height.getHeight() >= 150 && height.getHeight() < 175) {
            smallDegree = (175 - height.getHeight()) / 25.0;
        } else {
            smallDegree = 0.0;
        }
        return smallDegree;
    }

    private Double initializeMidDegree() {
        Double midDegree;
        if(height.getHeight() >= 170 && height.getHeight() < 185) {
            midDegree = (height.getHeight() - 170) / 15.0;
        } else if(height.getHeight() >= 185 && height.getHeight() < 190) {
            midDegree = (190 - height.getHeight()) / 15.0;
        } else {
            midDegree = 0.0;
        }
        return midDegree;
    }

    private Double initializeLargeDegree() {
        Double largeDegree;
        if(height.getHeight() <= 180) {
            largeDegree = 0.0;
        } else if(height.getHeight() > 180 && height.getHeight() < 195) {
            largeDegree = (height.getHeight() - 180) / 15.0;
        } else {
            largeDegree = 1.0;
        }
        return largeDegree;
    }
}
