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
    public String search() {
        EternalPreferences eternalPreferences = EternalPreferences.getInstance();
        eternalPreferences.setCustomerServicePreference(0.7);
        eternalPreferences.setSeatComfortabilityPreference(0.8);
        eternalPreferences.setFoodPreference(0.9);
        eternalPreferences.setHeight(new Height(210));
        ViewClient client = ViewClient.getViewClientInstance();
        View view = client.createWebpage(Webpage.FLIGHT_SEARCH_PAGE);
        return view.getViewContent();
    }

    @PostMapping("/ephemeral")
    public String ephemeralSearch() {
        FlightPreferences flightPreferences = FlightPreferences.getInstance();
        flightPreferences.setAdults(1);
        flightPreferences.setIsDirectFlight(Boolean.TRUE);
        flightPreferences.setDepartureDateTime("2025-05-02");
        flightPreferences.setOriginAirport(new Airport("ZRH"));
        flightPreferences.setDestinationAirport(new Airport("HAN"));
        HandleAPIRequestCommand handleAPIRequestCommand = new HandleAPIRequestCommand();
        handleAPIRequestCommand.execute();
        ViewClient client = ViewClient.getViewClientInstance();
        View view = client.createWebpage(Webpage.EPHEMERAL_PREF_PAGE);
        return view.getViewContent();
    }
}
