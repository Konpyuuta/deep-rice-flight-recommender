package org.example.deeprice.controller;


import org.example.deeprice.commands.api.HandleAPIRequestCommand;
import org.example.deeprice.model.Airport;
import org.example.deeprice.model.preferences.EternalPreferences;
import org.example.deeprice.model.preferences.FlightPreferences;
import org.example.deeprice.model.user.User;
import org.example.deeprice.model.user.criteria.Height;
import org.example.deeprice.view.View;
import org.example.deeprice.view.ViewClient;
import org.example.deeprice.view.Webpage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Maurice Amon
 */

@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping("/")
public class RestController {


    @GetMapping("/ephemeral")
    public String emphemeral() {
        ViewClient client = ViewClient.getViewClientInstance();
        View view = client.createWebpage(Webpage.EPHEMERAL_PREF_PAGE);
        return view.getViewContent();
    }

    @GetMapping("/flight")
    public String flightChooser() {
        ViewClient client = ViewClient.getViewClientInstance();
        View view = client.createWebpage(Webpage.FLIGHT_SEARCH_PAGE);
        return view.getViewContent();
    }

    @GetMapping("/ranking")
    public String ranking() {
        ViewClient client = ViewClient.getViewClientInstance();
        View view = client.createWebpage(Webpage.RANKING_PAGE);
        return view.getViewContent();
    }

    @GetMapping("/")
    public String login() {
        ViewClient client = ViewClient.getViewClientInstance();
        View view = client.createWebpage(Webpage.LOGIN_PAGE);
        return view.getViewContent();
    }

    @PostMapping("/start")
    public String start(@RequestParam String inputName, @RequestParam String inputMail) {
        User user = User.getInstance();
        user.setUsername(inputName);
        user.setEmail(inputMail);
        ViewClient client = ViewClient.getViewClientInstance();
        View view = client.createWebpage(Webpage.ETERNAL_PREF_PAGE);

        System.out.println("Name: " + inputName + " Email: " + inputMail);
        return view.getViewContent();
    }

    @PostMapping("/flight-search")
    public String search(@RequestParam String flighttime, @RequestParam String customerservice, @RequestParam String seat, @RequestParam String height, @RequestParam String foodservice) {
        EternalPreferences eternalPreferences = EternalPreferences.getInstance();
        eternalPreferences.setCustomerServicePreference(0.2*Integer.valueOf(customerservice));
        eternalPreferences.setSeatComfortabilityPreference(0.2*Integer.valueOf(seat));
        eternalPreferences.setFoodPreference(0.2*Integer.valueOf(foodservice));
        eternalPreferences.setHeight(new Height(Integer.valueOf(height)));
        ViewClient client = ViewClient.getViewClientInstance();
        View view = client.createWebpage(Webpage.FLIGHT_SEARCH_PAGE);
        return view.getViewContent();
    }

    @PostMapping("/ephemeral")
    public String ephemeralSearch(@RequestParam String departureField, @RequestParam String arrivalField, @RequestParam String departureDateField, @RequestParam String flightClass) {
        System.out.println("Departure" + departureField);
        System.out.println("Arrival" + arrivalField);
        System.out.println("Departure Date" + departureDateField);
        System.out.println("FlightClass" + flightClass);
        FlightPreferences flightPreferences = FlightPreferences.getInstance();
        flightPreferences.setAdults(1);
        flightPreferences.setDepartureDateTime(departureDateField);
        flightPreferences.setOriginAirport(new Airport(departureField));
        flightPreferences.setDestinationAirport(new Airport(arrivalField));
        flightPreferences.setFlightClass(flightClass);
        HandleAPIRequestCommand handleAPIRequestCommand = new HandleAPIRequestCommand();
        handleAPIRequestCommand.execute();
        ViewClient client = ViewClient.getViewClientInstance();
        View view = client.createWebpage(Webpage.EPHEMERAL_PREF_PAGE);
        return view.getViewContent();
    }
}
