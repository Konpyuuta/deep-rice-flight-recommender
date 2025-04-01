package org.example.deeprice.commands;

import org.example.deeprice.model.Airline;
import org.example.deeprice.model.Flight;
import org.example.deeprice.model.rating.Rating;
import org.example.deeprice.model.rating.matrix.RatingTuple;
import org.example.deeprice.model.rating.matrix.UserPreferenceTuple;
import org.example.deeprice.model.user.User;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Maurice Amon
 *
 * This class serves the purpose
 */

public class CalculateSimilarityCommand implements Command {

    private User user;

    private RatingTuple ratingTuple;

    private Map<Float, Flight> cosineSimToFlightMap = new HashMap<>();

    public CalculateSimilarityCommand(User user, RatingTuple ratingTuple) {
        this.user = user;
        this.ratingTuple = ratingTuple;
    }

    @Override
    public void execute() {
        Float[] userPrefs = new Float[10];
        Float[] ratings = new Float[10];

        float dotProduct = 0;
        float normUser = 0;
        float normRating = 0;
        for (int i = 0; i < userPrefs.length; i++) {
            dotProduct += userPrefs[i] * ratings[i];
            normUser += Math.pow(userPrefs[i], 2);
            normRating += Math.pow(ratings[i], 2);
        }
        Double cosineSimilarity = dotProduct / (Math.sqrt(normUser) * Math.sqrt(normRating));
        //cosineSimToFlightMap.put(cosineSimilarity, new Flight("", new Airline("", "", new Rating()), "", "");
    }
}
