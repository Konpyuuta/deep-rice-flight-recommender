package org.example.deeprice.model.result;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maurice Amon
 */

public class APIFlightResponse {

    private static APIFlightResponse instance = null;

    private List<FlightOffer> flightOffers;

    private APIFlightResponse() {
        flightOffers = new ArrayList<FlightOffer>();
    }

    public static APIFlightResponse getInstance() {
        if (instance == null) {
            instance = new APIFlightResponse();
        }
        return instance;
    }

    public void addFlightOffer(FlightOffer flightOffer) {
        flightOffers.add(flightOffer);
    }

    public void removeFlightOffer(FlightOffer flightOffer) {
        flightOffers.remove(flightOffer);
    }

    public List<FlightOffer> getFlightOffers() {
        return flightOffers;
    }


}
