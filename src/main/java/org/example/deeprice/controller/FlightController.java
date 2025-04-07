package org.example.deeprice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FlightController {

    // Serve the flight search page
    @GetMapping("/search")
    public String showFlightSearchPage() {
        return "search";
    }

    // Handle the form submission
    @PostMapping("/search-results")
    public String searchFlights(
            @RequestParam("from") String from,
            @RequestParam("to") String to,
            @RequestParam("departureDate") String departureDate,
            Model model) {

        model.addAttribute("from", from);
        model.addAttribute("to", to);
        model.addAttribute("departureDate", departureDate);

        return "search-results"; // Redirects to results page
    }
}
