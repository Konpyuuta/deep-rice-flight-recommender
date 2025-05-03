package org.example.deeprice.model.result.flight;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Results {

    private static List<FlightJourney> FLIGHT_JOURNEY_LIST;

    public static Map<String, String> IATA_TO_AIRLINE_LIST;

    public static List<PreparedResults> PREPARED_RESULTS_LIST;

    public static List<FlightJourney> FINAL_RESULTS_LIST;

    public static synchronized List<FlightJourney> getFlightJourneyList() {
        return FLIGHT_JOURNEY_LIST;
    }

    public static synchronized void setFlightJourneyList(List<FlightJourney> flightJourneyList) {
        FLIGHT_JOURNEY_LIST = flightJourneyList;
    }

    public static synchronized List<FlightJourney> getFilteredFlightJourneyList() {
        return FLIGHT_JOURNEY_LIST;
    }

    public static synchronized List<PreparedResults> getPreparedResultsList() {
        return PREPARED_RESULTS_LIST;
    }

    public static synchronized void setPreparedResultsList(List<PreparedResults> preparedResultsList) {
        PREPARED_RESULTS_LIST = preparedResultsList;
    }

    public static synchronized void setPreparedResults(List<FlightJourney> flightJourneyList) {
        FINAL_RESULTS_LIST = flightJourneyList;
    }

    public static synchronized List<FlightJourney> getFinalResultsList() {
        return FINAL_RESULTS_LIST;
    }
}
