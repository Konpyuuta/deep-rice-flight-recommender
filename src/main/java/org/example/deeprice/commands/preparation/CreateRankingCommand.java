package org.example.deeprice.commands.preparation;

import org.example.deeprice.commands.CalculatePriceStandardDeviationCommand;
import org.example.deeprice.commands.CalculateSimilarityCommand;
import org.example.deeprice.commands.CalculateStandardDeviationCommand;
import org.example.deeprice.commands.Command;
import org.example.deeprice.commands.api.FetchAirlineRatingsCommand;
import org.example.deeprice.model.preferences.EternalPreferences;
import org.example.deeprice.model.result.flight.*;
import org.example.deeprice.model.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class bears the responsibility of creating a Top N ranking of the fetched flights..
 *
 * @author Maurice Amon
 */
public class CreateRankingCommand implements Command {

    private final Integer TOP_N = 20;

    private final Map<Integer, PreparedResults> rankToResultMap = new HashMap<>();

    private List<FlightJourney> flightJourneyList;

    private Double timeMean;

    private Double timeSD;

    private Double priceMean;

    private Double priceSD;

    private final Map<FlightJourney, Double> journeyToResultMap = new HashMap<>();

    private List<FlightJourney> sortedJourneyList;

    private List<String> airlineList;


    public CreateRankingCommand(List<String> airlineList) {
        this.airlineList = airlineList;
        flightJourneyList = Results.getFilteredFlightJourneyList();
        calculateFlightTimeStandardDeviation();
        calculatePriceStandardDeviation();
    }

    @Override
    public void execute() {
        for (FlightJourney flightJourney : flightJourneyList) {
            calculateCosineSimilarity(flightJourney);
        }
        sortedJourneyList = journeyToResultMap.entrySet()
                .stream()
                .sorted(Map.Entry.<FlightJourney, Double>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        Results.setPreparedResults(sortedJourneyList);

        for(FlightJourney flightJourney : sortedJourneyList) {
            System.out.println("Price " + flightJourney.getPrice());
            System.out.println("Rating: " + journeyToResultMap.get(flightJourney).doubleValue());
        }
    }

    private Double calculateCosineSimilarity(FlightJourney flightJourney) {
        User user = User.getInstance();
        List<String> carrierCodes = extractCarrierCode(flightJourney);
        List<Double[]> resultVectorList = new ArrayList<>();
        Double timeValue = calculateValue((flightJourney.getTotalJourneyTime() - timeMean) / timeSD);
        Double priceValue = calculateValue((flightJourney.getPrice() - priceMean) / priceSD);
        for (String carrierCode : carrierCodes) {
            FetchAirlineRatingsCommand fetchAirlineRatingsCommand = new FetchAirlineRatingsCommand(carrierCode);
            fetchAirlineRatingsCommand.execute();
            CalculateSimilarityCommand calculateSimilarityCommand = new CalculateSimilarityCommand(user,
                    fetchAirlineRatingsCommand.getNodePropertyMap());
            calculateSimilarityCommand.execute();
            resultVectorList.add(calculateSimilarityCommand.getRatingMatch());
        }
        addRatings(flightJourney, resultVectorList);
        for(Double[] resVector : resultVectorList) {
            Double[] glob  = CalculateSimilarityCommand.calculateGlobalsMatch(timeValue, priceValue);
            resVector[4] = glob[0];
            resVector[5] = glob[1];
        }
        Double negSum = 0.0;
        for(Double[] resultVector : resultVectorList) {
            for(int i = 0; i < resultVector.length; i++) {
                 negSum += resultVector[i];
            }
        }
        flightJourney.setTimeSD(timeSD);
        double val = (flightJourney.getPrice() - priceMean)/priceSD;
        flightJourney.setPriceSD(val);
        journeyToResultMap.put(flightJourney, (negSum / resultVectorList.size()));
        return 0.0;
    }

    private void addRatings(FlightJourney flightJourney, List<Double[]> resultVectorList) {
        int counter = 0;
        for(FlightItinerary itinerary : flightJourney.getFlightItineraries()) {
            for(Flight flight : itinerary.getFlights()) {
                flight.setRatings(resultVectorList.get(counter));
            }
        }
    }

    private List<String> extractCarrierCode(FlightJourney flightJourney) {
        List<String> carrierCodeList = new ArrayList<>();
        for(FlightItinerary flightItinerary : flightJourney.getFlightItineraries()) {
            for(Flight flight : flightItinerary.getFlights()) {
                carrierCodeList.add(flight.getCarrierCode());
            }
        }
        return carrierCodeList;
    }

    private void calculateFlightTimeStandardDeviation() {
        CalculateStandardDeviationCommand cs = new CalculateStandardDeviationCommand(flightJourneyList);
        cs.execute();
        timeSD = cs.getStandardDeviation();
        timeMean = cs.getMean();
    }

    private void calculatePriceStandardDeviation() {
        CalculatePriceStandardDeviationCommand cs = new CalculatePriceStandardDeviationCommand(flightJourneyList);
        cs.execute();
        priceSD = cs.getStandardDeviation();
        priceMean = cs.getMean();
    }

    private Double calculateValue(Double z) {
        Double zValue = (double)Math.round(z);
        if(zValue < -2.0) {
            zValue = -2.0;
        } else if(zValue > 2.0) {
            zValue = 2.0;
        }
        return zValue;
    }

    public List<FlightJourney> getRankedFlightJourneyList() {
        return sortedJourneyList;
    }

}
