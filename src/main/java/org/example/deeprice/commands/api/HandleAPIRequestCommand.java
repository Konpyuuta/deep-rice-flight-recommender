package org.example.deeprice.commands.api;

import org.example.deeprice.commands.Command;
import org.example.deeprice.model.Meal;
import org.example.deeprice.model.preferences.FlightPreferences;
import org.example.deeprice.model.result.APIFlightResponse;
import org.example.deeprice.model.result.FlightOffer;

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
    private final Integer maxResults = 10;

    public HandleAPIRequestCommand() {
        FlightPreferences flightPreferences = FlightPreferences.getInstance();
        this.originLocationCode = flightPreferences.getOriginAirport().getAirportID();
        this.destinationLocationCode = flightPreferences.getInstance().getDestinationAirport().getAirportID();
        this.departureDate = flightPreferences.getDepartureDateTime();
        this.adults = String.valueOf(flightPreferences.getAdults());

    }

    @Override
    public void execute() {
        AmadeusFlightsAPICommand apiCommand = new AmadeusFlightsAPICommand();
        apiCommand.initializeParameter("originLocationCode", originLocationCode);
        apiCommand.initializeParameter("destinationLocationCode", destinationLocationCode);
        apiCommand.initializeParameter("departureDate", departureDate);
        apiCommand.initializeParameter("adults", adults);
        apiCommand.execute();
        parseResponse(apiCommand.getResponse());
        //originLocationCode=ZRH&destinationLocationCode=BKK&departureDate=2025-05-02&adults=1&nonStop=false&max=250
    }

    private void parseResponse(String response) {
        ParseAPIResponseCommand parseAPIResponseCommand = new ParseAPIResponseCommand(response);
        parseAPIResponseCommand.execute();
        List<FlightOffer> offers = APIFlightResponse.getInstance().getFlightOffers();
        for(FlightOffer offer: offers) {
            System.out.println(offer);
        }
    }
}
