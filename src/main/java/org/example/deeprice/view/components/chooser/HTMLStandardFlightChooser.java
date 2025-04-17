package org.example.deeprice.view.components.chooser;

/**
 *
 *
 * @author Maurice Amon
 */

public class HTMLStandardFlightChooser extends HTMLFlightchooser {

    public HTMLStandardFlightChooser() {
        initializeContent();
    }

    @Override
    protected void initializeContent() {
        content = "<h1 class=\"text-center\">Find & Compare Flights Easily ✈\uFE0F</h1><br /><br /><div class=\"container py-5 bg-light\" style=\"border-radius: 15px;\"><div class=\"hero\">\n" +
                "        \n" +
                "        <div class=\"search-box\">\n" +
                "<form action=\"/ephemeral\" id=\"flightSearchForm\" method=\"post\">\n" +
                "  <div class=\"form-group row\">\n" +
                "    <label for=\"departureField\" class=\"col-sm-2 col-form-label\">From: </label>\n" +
                "    <div class=\"col-sm-10\">\n" +
                "      <input type=\"text\" class=\"form-control\" id=\"departureField\" aria-describedby=\"airportHelp\" placeholder=\"Origin airport ID\">\n" +
                "      <small id=\"airportHelp\" class=\"form-text text-muted\">For example 'ZRH' for the airport in zurich</small>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "  <div class=\"form-group row\">\n" +
                "    <label for=\"arrivalField\" class=\"col-sm-2 col-form-label\">To: </label>\n" +
                "    <div class=\"col-sm-10\">\n" +
                "      <input type=\"text\" class=\"form-control\" id=\"arrivalField\" aria-describedby=\"airportHelp2\" placeholder=\"Destination airport ID\">\n" +
                "      <small id=\"airportHelp2\" class=\"form-text text-muted\">For example 'SGN' for the airport in Ho Chi Minh City</small>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "  <div class=\"form-group row\">\n" +
                "    <label for=\"departureDateField\" class=\"col-sm-2 col-form-label\">Departure Date: </label>\n" +
                "    <div class=\"col-sm-3\">\n" +
                "      <input type=\"date\" class=\"form-control\" id=\"departureDateField\">\n" +
                "    </div>\n" +
                "  </div>\n" +
                "  <div class=\"form-group row\">\n" +
                "    <label for=\"arrivalDateField\" class=\"col-sm-2 col-form-label\">Arrival Date: </label>\n" +
                "    <div class=\"col-sm-3\">\n" +
                "      <input type=\"date\" class=\"form-control\" id=\"arrivalDateField\">\n" +
                "    </div>\n" +
                "  </div>\n" +
                "  <fieldset class=\"form-group\">\n" +
                "    <div class=\"row\">\n" +
                "      <legend class=\"col-form-label col-sm-2 pt-0\">Passengers: </legend>\n" +
                "      <div class=\"col-sm-10\">\n" +
                "        <div class=\"form-check\">\n" +
                "          <input class=\"form-check-input\" type=\"radio\" name=\"gridRadios\" id=\"gridRadios1\" value=\"option1\" checked>\n" +
                "          <label class=\"form-check-label\" for=\"gridRadios1\">\n" +
                "            1\n" +
                "          </label>\n" +
                "        </div>\n" +
                "        <div class=\"form-check\">\n" +
                "          <input class=\"form-check-input\" type=\"radio\" name=\"gridRadios\" id=\"gridRadios2\" value=\"option2\">\n" +
                "          <label class=\"form-check-label\" for=\"gridRadios2\">\n" +
                "            2\n" +
                "          </label>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "  </fieldset>\n" +
                "  <div class=\"form-group row\">\n" +
                "    <div class=\"col-sm-2\">Class: </div>\n" +
                "    <div class=\"col-sm-3\">\n" +
                "        <select class=\"form-control\">\n" +
                "               <option>Economy</option>\n" +
                "               <option>Business</option>\n" +
                "               <option>First Class</option>\n" +
                "        </select>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "  <div class=\"form-group row\">\n" +
                "    <div class=\"col-sm-10\">\n" +
                "      <button type=\"submit\" class=\"btn btn-primary\"> \uD83D\uDD0D Search Flights</button>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</form></div></div></div>\n" +
                "\n" +
                "    <script src=\"script.js\"></script>";
    }
}
