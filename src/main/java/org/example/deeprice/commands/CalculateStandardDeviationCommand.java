package org.example.deeprice.commands;

import org.example.deeprice.model.result.flight.FlightJourney;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Maurice Amon
 */

public class CalculateStandardDeviationCommand implements Command {

    private Map<FlightJourney, Double> flightJourneyToSDMap = new HashMap<>();

    private List<FlightJourney> flightJourneyList;

    private Double mean;

    private Integer N;

    Double standardDeviation;

    public CalculateStandardDeviationCommand(List<FlightJourney> flightJourneys) {
        this.flightJourneyList = flightJourneys;
        this.N = flightJourneyList.size();
    }

    @Override
    public void execute() {
        calculateMean();
        Double nominator = 0.0;
        for (FlightJourney flightJourney : flightJourneyList) {
            nominator += Math.pow(flightJourney.getTotalJourneyTime() - mean, 2);
        }
        standardDeviation = Math.sqrt(nominator / N);
    }

    private void calculateMean() {
        Double meanTotalTime = 0.0;
        for(FlightJourney flightJourney : flightJourneyList) {
            meanTotalTime += flightJourney.getTotalJourneyTime();
        }
        mean = meanTotalTime / flightJourneyList.size();
    }

    public Double getStandardDeviation() {
        return standardDeviation;
    }

    public Double getMean() {
        return mean;
    }
}
