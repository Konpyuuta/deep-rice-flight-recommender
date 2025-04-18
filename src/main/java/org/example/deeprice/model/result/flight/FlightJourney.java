package org.example.deeprice.model.result.flight;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maurice Amon
 */

public class FlightJourney {

    private String journeyId;

    private List<FlightItinerary> flightItineraries = new ArrayList<>();

    private Double price;

    private AllowedLuggage allowedLuggage;

    public FlightJourney(String journeyId, List<FlightItinerary> flightItineraries, Double price) {
        this.journeyId = journeyId;
        this.flightItineraries = flightItineraries;
        this.price = price;
    }

    public FlightJourney() {

    }

    public void setAllowedLuggage(AllowedLuggage allowedLuggage) {
        this.allowedLuggage = allowedLuggage;
    }

    public AllowedLuggage getAllowedLuggage() {
        return allowedLuggage;
    }

    public void setFlightItineraries(List<FlightItinerary> flightItineraries) {
        this.flightItineraries = flightItineraries;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setJourneyId(String journeyId) {
        this.journeyId = journeyId;
    }

    public String getJourneyId() {
        return journeyId;
    }

    public List<FlightItinerary> getFlightItineraries() {
        return flightItineraries;
    }

    public void addFlightItinerary(FlightItinerary flightItinerary) {
        flightItineraries.add(flightItinerary);
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        System.out.println("Number: " + journeyId + ", Layovers: " + flightItineraries.size());
        for(FlightItinerary itinerary : flightItineraries) {
            sb.append(itinerary.toString() + "\n");
        }
        return sb.toString();
    }
}
