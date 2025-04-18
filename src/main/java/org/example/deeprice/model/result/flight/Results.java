package org.example.deeprice.model.result.flight;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Results {

    private static List<FlightJourney> FLIGHT_JOURNEY_LIST;

    public static Map<String, String> IATA_TO_AIRLINE_LIST;

    public static synchronized List<FlightJourney> getFlightJourneyList() {
        return FLIGHT_JOURNEY_LIST;
    }

    public static synchronized void setFlightJourneyList(List<FlightJourney> flightJourneyList) {
        FLIGHT_JOURNEY_LIST = flightJourneyList;
    }
}
