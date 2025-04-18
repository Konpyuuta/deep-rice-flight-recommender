package org.example.deeprice.commands.preparation;

import org.example.deeprice.commands.Command;
import org.example.deeprice.model.result.flight.FlightJourney;

import java.util.List;

/**
 *
 * @author Maurice Amon
 */

public class PrepareFlightDataCommand implements Command {

    private List<FlightJourney> flightJourneyList;

    public PrepareFlightDataCommand(List<FlightJourney> flightJourneyList) {
        this.flightJourneyList = flightJourneyList;
    }

    @Override
    public void execute() {

    }
}
