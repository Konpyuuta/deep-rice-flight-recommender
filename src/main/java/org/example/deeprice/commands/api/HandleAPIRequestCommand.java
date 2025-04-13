package org.example.deeprice.commands.api;

import org.example.deeprice.commands.Command;
import org.example.deeprice.model.Meal;
import org.example.deeprice.model.result.APIFlightResponse;
import org.example.deeprice.model.result.FlightOffer;

import java.util.List;

/**
 *
 * @author MAurice Amon
 */

public class HandleAPIRequestCommand implements Command {

    // Flight details ..
    private String originLocationCode;
    private String destinationLocationCode;
    private String departureDate;
    private String adults;
    private final Integer maxResults = 10;

    // Longterm preferences ..
    private Double flightTimeImportance;
    private Double priceToServiceRatio;
    private Double height;
    private Meal meal;

    public HandleAPIRequestCommand(String originLocationCode, String destinationLocationCode, String departureDate, String adults, Double flightTimeImportance, Double priceToServiceRatio, Double height, Meal meal) {
        this.originLocationCode = originLocationCode;
        this.destinationLocationCode = destinationLocationCode;
        this.departureDate = departureDate;
        this.adults = adults;
        this.flightTimeImportance = flightTimeImportance;
        this.priceToServiceRatio = priceToServiceRatio;
        this.height = height;
        this.meal = meal;
    }

    @Override
    public void execute() {
        AmadeusFlightsAPICommand apiCommand = new AmadeusFlightsAPICommand();
        apiCommand.initializeParameter("originLocationCode", originLocationCode);
        apiCommand.initializeParameter("destinationLocationCode", destinationLocationCode);
        apiCommand.initializeParameter("departureDate", departureDate);
        apiCommand.initializeParameter("adults", adults);
        apiCommand.execute();
        ParseAPIResponseCommand parseAPIResponseCommand = new ParseAPIResponseCommand(apiCommand.getResponse());
        parseAPIResponseCommand.execute();
        List<FlightOffer> offers = APIFlightResponse.getInstance().getFlightOffers();
        for(FlightOffer offer: offers) {
            System.out.println(offer);
        }
        //originLocationCode=ZRH&destinationLocationCode=BKK&departureDate=2025-05-02&adults=1&nonStop=false&max=250
    }
}
