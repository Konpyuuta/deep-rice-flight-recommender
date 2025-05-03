package org.example.deeprice.view.components.topn;

import org.example.deeprice.ProjectConstants;
import org.example.deeprice.model.result.flight.FlightJourney;
import org.example.deeprice.model.result.flight.Results;

import java.util.List;

/**
 *
 * @author Maurice Amon
 */

public class HTMLStandardRankingTopN extends HTMLRankingTopN {

    public HTMLStandardRankingTopN() {
        initializeContent();
    }


    @Override
    protected void initializeContent() {
        content = "<div class=\"container py-5\"><nav aria-label=\"breadcrumb\">\n" +
                "  <ol class=\"breadcrumb\">\n" +
                "    <li class=\"breadcrumb-item\" aria-current=\"page\">" + ProjectConstants.ETERNAL_PREF_NAV + "</li>\n" +
                "    <li class=\"breadcrumb-item\" aria-current=\"page\">Eternal Preferences</li>\n" +
                "    <li class=\"breadcrumb-item\" aria-current=\"page\">Choose Flight</li>\n" +
                "    <li class=\"breadcrumb-item\" ><a href=\"ephemeral\">Ephemeral Preferences</a></li>   " +
                "    <li class=\"breadcrumb-item active\">Flight Ranking</li>   " +
                "  </ol>\n<div class=\"container py-5 bg-light\" style=\"border-radius: 15px;\"><table class=\"table\">\n" +
                "  <thead>\n" +
                "    <tr>\n" +
                "      <th scope=\"col\">#</th>\n" +
                "      <th scope=\"col\">Flight</th>\n" +
                "    </tr>\n" +
                "  </thead>\n" +
                "  <tbody>\n";

        List<FlightJourney> fj = Results.getFinalResultsList();
        int counter = 1;
        if (fj.isEmpty()) {
            content += "<div class=\"alert alert-primary\" role=\"alert\">\n" +
                    "  No flight have been found for your preferences.\n" +
                    "</div>";
        }
        for(FlightJourney fj1 : fj) {
            content +=
                    "    <tr>\n" +
                    "      <th scope=\"row\">" + counter + "</th>\n" +
                    "      <td>";
            content += fj1.toString();
            content += "</td>\n" +
                    "    </tr>\n" +
                    "    <tr>\n";
            counter++;
        }
        content +=
                "  </tbody>\n" +
                "</table></div>";
    }
}
