package org.example.deeprice.view.components.preferences;

import org.example.deeprice.ProjectConstants;

/**
 *
 *
 * @author Maurice Amon
 */

public class HTMLStandardPreferences extends HTMLPreferences {

    public HTMLStandardPreferences() {
        initializeForm();
    }

    @Override
    public void initializeForm() {
        form += "<div class=\"container py-5\"><nav aria-label=\"breadcrumb\">\n" +
                "  <ol class=\"breadcrumb\">\n" +
                "    <li class=\"breadcrumb-item active\">" + ProjectConstants.ETERNAL_PREF_NAV + "</li>\n" +
                "    <li class=\"breadcrumb-item aria-current=\"page\">Eternal Preferences</li>\n" +
                "  </ol>\n" +
                "</nav></div><h1 class=\"text-center\">Preferences</h1>\n" +
                "<div class=\"container py-5 bg-light\" style=\"border-radius: 15px;\">\n" +
                "<form action=\"/flight-search\" method=\"post\"><label for=\"flight-time-range\" class=\"form-label\">How important is the flight time to me when booking a flight?</label>\n" +
                "    <input type=\"range\" class=\"form-range\" min=\"1\" max=\"5\" name=\"flighttime\" id=\"flight-time-range\">" +
                "    <small id=\"emailHelp\" class=\"form-text text-muted\">Left side: I don't care about it at all. Middle: Neutral, care about it but it's not that important. Right side: Strongly care about it</small>\n" +
                "    <br>\n" +
                "    <br>\n" +
                "    <label for=\"price\" class=\"form-label\">How important is a cheap price of a flight to me?</label>\n" +
                "    <input type=\"range\" class=\"form-range\" min=\"1\" max=\"5\" name=\"price\" id=\"price\">\n" +
                "    <small id=\"emailHelp\" class=\"form-text text-muted\">Left side: I don't care about it at all. Middle: Neutral, care about it but it's not that important. Right side: Strongly care about it</small>\n" +

                "    <br><br>\n" +
                "    <label for=\"customer-service\" class=\"form-label\">How important is the customer service in the aircraft to me?</label>\n" +
                "    <input type=\"range\" class=\"form-range\" min=\"1\" max=\"5\" name=\"customerservice\" id=\"customer-service\">\n" +
                "    <small id=\"emailHelp\" class=\"form-text text-muted\">Left side: I don't care about it at all. Middle: Neutral, care about it but it's not that important. Right side: Strongly care about it</small>\n" +

                "    <br><br>\n" +
                "    <label for=\"seat\" class=\"form-label\">How important is the seat comfortability to me?</label>\n" +
                "    <input type=\"range\" class=\"form-range\" min=\"1\" max=\"5\" name=\"seat\" id=\"seat\">\n" +
                "    <small id=\"emailHelp\" class=\"form-text text-muted\">Left side: I don't care about it at all. Middle: Neutral, care about it but it's not that important. Right side: Strongly care about it</small>\n" +

                "    <br><br>\n" +
                "    <label for=\"food-service\" class=\"form-label\">How important is the Quality of the food served in the aircraft to me?</label>\n" +
                "    <input type=\"range\" class=\"form-range\" min=\"1\" max=\"5\" name=\"foodservice\" id=\"food-service\">\n" +
                "    <small id=\"emailHelp\" class=\"form-text text-muted\">Left side: I don't care about it at all. Middle: Neutral, care about it but it's not that important. Right side: Strongly care about it</small>\n" +

                "    <br>\n" +
                "    <br>\n" +
                "    <label for=\"height\" class=\"form-label\">How tall are you?</label>\n" +
                "    <div class=\"input-group mb-3\">\n" +
                "        <div class=\"input-group-prepend\">\n" +
                "            <button class=\"btn btn-outline-secondary dropdown-toggle\" id=\"height\" type=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">In cm</button>\n" +
                "            <div class=\"dropdown-menu\">\n" +
                "                <a class=\"dropdown-item\" href=\"#\">In feet</a>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <input type=\"text\" name=\"height\" class=\"form-control\" aria-label=\"Your height with different metric options\">\n" +
                "    </div>\n" +
                "    <br>\n" +
                "    <hr/>\n" +
                "    <br>\n" +
                "    <button type=\"submit\" class=\"btn btn-primary\">Save preferences</button>\n" +
                "</div></form>";
    }
}
