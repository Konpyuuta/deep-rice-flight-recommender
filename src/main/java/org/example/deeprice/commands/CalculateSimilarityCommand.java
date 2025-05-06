package org.example.deeprice.commands;

import org.example.deeprice.model.Flight;
import org.example.deeprice.model.preferences.EternalPreferences;
import org.example.deeprice.model.rating.map.FunctionalMapper;
import org.example.deeprice.model.rating.map.RatingKey;
import org.example.deeprice.model.rating.map.SDFunctionalPriceMapper;
import org.example.deeprice.model.rating.map.SDFunctionalTimeMapper;
import org.example.deeprice.model.user.User;

import java.util.*;

/**
 *
 * @author Maurice Amon
 *
 * This class serves the purpose
 */

public class CalculateSimilarityCommand implements Command {

    private User user;

    private Float[] ratings = new Float[4];

    private List<Float[]> flightVectors = new ArrayList<>();

    private Map<Float, Flight> cosineSimToFlightMap = new HashMap<>();

    private Double cosineSimilarity;

    private Double[] ratingMatch;

    public CalculateSimilarityCommand(User user, Map<String, Object> airlineProps) {
        this.user = user;
        ratings[0] = Float.valueOf(airlineProps.get("food").toString());
        ratings[1] = Float.valueOf(airlineProps.get("customerService").toString());
        ratings[2] = Float.valueOf(airlineProps.get("seatComfort").toString());
        ratings[3] = Float.valueOf(airlineProps.get("legroom").toString());

    }

    @Override
    public void execute() {
        Float[] userPrefs = new Float[10];
        fetchUserPreferences(userPrefs);
        ratingMatch = new Double[6];
        for(int i = 0; i < 4; i++) {
            Double match = calculatePreferenceMatch(userPrefs[i].doubleValue(), ratings[i].doubleValue());
            ratingMatch[i] = match;
        }

        /*float dotProduct = 0;
        float normUser = 0;
        float normRating = 0;
        for (int i = 0; i < userPrefs.length; i++) {
            dotProduct += userPrefs[i] * ratings[i];
            normUser += Math.pow(userPrefs[i], 2);
            normRating += Math.pow(ratings[i], 2);
        }
        cosineSimilarity = dotProduct / (Math.sqrt(normUser) * Math.sqrt(normRating));*/
        //cosineSimToFlightMap.put(cosineSimilarity, new Flight("", new Airline("", "", new Rating()), "", "");
    }

    public static Double[] calculateGlobalsMatch(Double timeValue, Double priceValue) {
        Double[] globalsMatch = new Double[2];
        globalsMatch[0] = calculateSDMatch(EternalPreferences.getInstance().getFlightTimePreference(), timeValue.doubleValue(), SDFunctionalTimeMapper.getRatingFunctionMap());
        globalsMatch[1] = calculateSDMatch(EternalPreferences.getInstance().getPricePreference(), priceValue.doubleValue(), SDFunctionalPriceMapper.getRatingFunctionMap());
        return globalsMatch;
    }

    private void fetchUserPreferences(Float[] userPrefs) {
        EternalPreferences prefs = EternalPreferences.getInstance();
        userPrefs[0] = prefs.getFoodPreference().floatValue();
        userPrefs[1] = prefs.getCustomerServicePreference().floatValue();
        userPrefs[2] = prefs.getSeatComfortabilityPreference().floatValue();
        userPrefs[3] = (float)Math.round(calculateFuzzyHeight());

    }

    private Double calculatePreferenceMatch(Double userPref, Double airlineRating) {
        Map<RatingKey, Double> ratingMap = FunctionalMapper.getRatingFunctionMap();
        Set<RatingKey> keys = ratingMap.keySet();
        RatingKey rightKey = new RatingKey(userPref, airlineRating);
        for (RatingKey key : keys) {
            if(key.getUserRating().doubleValue() == rightKey.getUserRating().doubleValue() && key.getSystemRating().doubleValue() == rightKey.getSystemRating().doubleValue()) {
                return ratingMap.get(key);
            }
        }
        return ratingMap.get(new RatingKey(userPref, airlineRating));
    }

    private static Double calculateSDMatch(Double userPref, Double sd, Map<RatingKey, Double> ratingMap) {
        Set<RatingKey> keys = ratingMap.keySet();
        RatingKey rightKey = new RatingKey(userPref, sd);
        for (RatingKey key : keys) {
            if(key.getUserRating().doubleValue() == rightKey.getUserRating().doubleValue() && key.getSystemRating().doubleValue() == rightKey.getSystemRating().doubleValue()) {
                return ratingMap.get(key);
            }
        }
        return ratingMap.get(new RatingKey(userPref, sd));
    }

    private Double calculateFuzzyHeight() {
        //RatingDeclaration ratingDeclaration = null;
        EternalPreferences prefs = EternalPreferences.getInstance();
        Double height = prefs.getHeight().getHeight().doubleValue();
        if(height < 160) {
            return 1.0;
        } else if (height >= 160 && height < 170) {
            return (2.0 + (((height + 1) - 160)/10));
        } else if(height >= 170 && height < 180) {
            return (3.0 + (((height + 1) - 170)/10));
        } else if(height >= 180 && height < 190) {
            return (4.0 + (((height + 1) - 180)/10));
        } else {
            return 5.0;
        }
        //FuzzyHeight fuzzyHeight = new FuzzyHeight(prefs.getHeight());
        /*if(legroomRating >= 4.0) {
            Double tallDegree = fuzzyHeight.getFuzzyArray()[2];
            if(tallDegree >= 0.0 && tallDegree <= 0.2) {
                ratingDeclaration = RatingDeclaration.STRONG_ADVANTAGE;
            } else if (tallDegree >= 0.2 && tallDegree < 1) {
                ratingDeclaration = RatingDeclaration.ADVANTAGE;
            } else {
                ratingDeclaration = RatingDeclaration.SPECIAL_NOTE;
            }

        }
        if (legroomRating >= 3.0 && legroomRating < 4.0) {
            Double tallDegree = fuzzyHeight.getFuzzyArray()[2];
            if(tallDegree >= 0.0 && tallDegree <= 0.2) {
                ratingDeclaration = RatingDeclaration.NEUTRAL;
            } else if (tallDegree >= 0.2 && tallDegree <= 0.6) {
                ratingDeclaration = RatingDeclaration.DISADVANTAGE;
            } else {
                ratingDeclaration = RatingDeclaration.STRONG_DISADVANTAGE;
            }
        }
        if(legroomRating >= 2.0 && legroomRating < 3.0) {
            Double tallDegree = fuzzyHeight.getFuzzyArray()[2];
            Double midDegree = fuzzyHeight.getFuzzyArray()[1];
            Double smallDegree = fuzzyHeight.getFuzzyArray()[0];

            if(smallDegree >= 0.8 && tallDegree == 0.0) {
                ratingDeclaration = RatingDeclaration.NEUTRAL;
            } else if (smallDegree >= 0.2 && smallDegree < 0.8) {
                ratingDeclaration = RatingDeclaration.DISADVANTAGE;
            } else if (tallDegree > 0.0) {
                ratingDeclaration = RatingDeclaration.STRONG_DISADVANTAGE;
            }
        }*/
    }

    public Double getCosineSimilarity() {
        return cosineSimilarity;
    }

    public Double[] getRatingMatch() {
        return ratingMatch;
    }

}
