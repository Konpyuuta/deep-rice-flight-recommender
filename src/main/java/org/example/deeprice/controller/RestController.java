package org.example.deeprice.controller;


import org.example.deeprice.model.user.User;
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
}
