package org.example.deeprice.commands.api;

import org.example.deeprice.commands.Command;
import org.example.deeprice.model.Meal;
import org.example.deeprice.model.preferences.FlightPreferences;
import org.example.deeprice.model.result.APIFlightResponse;
import org.example.deeprice.model.result.FlightOffer;
import org.example.deeprice.model.result.flight.FlightJourney;
import org.example.deeprice.model.result.flight.Results;

import java.util.List;

/**
 *
 * @author Maurice Amon
 */

public class HandleAPIRequestCommand implements Command {

    // Flight details ..
    private String originLocationCode;
    private String destinationLocationCode;
    private String departureDate;
    private String adults;
    private String flightClass;
    private final Integer maxResults = 10;

    public HandleAPIRequestCommand() {
        FlightPreferences flightPreferences = FlightPreferences.getInstance();
        this.originLocationCode = flightPreferences.getOriginAirport().getAirportID();
        this.destinationLocationCode = flightPreferences.getInstance().getDestinationAirport().getAirportID();
        this.departureDate = flightPreferences.getDepartureDateTime();
        this.adults = String.valueOf(flightPreferences.getAdults());
        this.flightClass = flightPreferences.getFlightClass();

    }

    @Override
    public void execute() {
        AmadeusFlightsAPICommand apiCommand = new AmadeusFlightsAPICommand();
        FlightPreferences flightPreferences = FlightPreferences.getInstance();
        apiCommand.initializeParameter("originLocationCode", flightPreferences.getOriginAirport().getAirportID());
        apiCommand.initializeParameter("destinationLocationCode", flightPreferences.getDestinationAirport().getAirportID());
        apiCommand.initializeParameter("departureDate", flightPreferences.getDepartureDateTime());
        apiCommand.initializeParameter("adults", String.valueOf(flightPreferences.getAdults()));
        apiCommand.initializeParameter("travelClass", flightPreferences.getFlightClass());
        apiCommand.execute();
        parseResponse(apiCommand.getResponse());
        //originLocationCode=ZRH&destinationLocationCode=BKK&departureDate=2025-05-02&adults=1&nonStop=false&max=250
    }

    private void parseResponse(String response) {
        ParseAPIResponseCommand parseAPIResponseCommand = new ParseAPIResponseCommand(response);
        parseAPIResponseCommand.execute();
        List<FlightJourney> offers = parseAPIResponseCommand.getFlightJourneys();
        Results.setFlightJourneyList(offers);
    }
}
