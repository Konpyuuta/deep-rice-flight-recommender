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
        content = "<div class=\"container py-5 bg-light\" style=\"border-radius: 15px;\"><div class=\"hero\">\n" +
                "        <h1 class=\"text-center\">Find & Compare Flights Easily ✈\uFE0F</h1>\n" +
                "        <div class=\"search-box\">\n" +
                "            <form id=\"flightSearchForm\">\n" +
                "                <div class=\"form-group\">\n" +
                "                    <div class=\"col-md-5\">\n" +
                "                        <label class=\"form-label\">From: </label>\n" +
                "                        <input type=\"text\" class=\"form-control airport-search\" id=\"from\" placeholder=\"Departure Airport\">\n" +
                "                    </div>\n" +
                "                    <div class=\"col-md-5\">\n" +
                "                        <label class=\"form-label\">To: </label>\n" +
                "                        <input type=\"text\" class=\"form-control airport-search\" id=\"to\" placeholder=\"Destination Airport\">\n" +
                "                    </div>\n" +
                "                    <div class=\"col-md-2\" style=\"margin-top: 10px;\">\n" +
                "                        <label class=\"form-label\">Passengers: </label>\n" +
                "                        <select class=\"form-select\" id=\"passengers\">\n" +
                "                            <option>1</option>\n" +
                "                            <option>2</option>\n" +
                "                            <option>3</option>\n" +
                "                            <option>4+</option>\n" +
                "                        </select>\n" +
                "                    </div>\n" +
                "               \n" +
                "                <div class=\"row mt-3\">\n" +
                "                    <div class=\"col-md-2\" style=\"width: 50%;\">\n" +
                "                        <label class=\"form-label\">Departure Date</label>\n" +
                "                        <input type=\"date\" class=\"form-control\" id=\"departure\">\n" +
                "                    </div>\n" +
                "                    <div class=\"col-md-2\" style=\"width: 50%;\">\n" +
                "                        <label class=\"form-label\">Return Date</label>\n" +
                "                        <input type=\"date\" class=\"form-control\" id=\"return\">\n" +
                "                    </div>\n" +
                "                    <div class=\"col-md-4\">\n" +
                "                        <label class=\"form-label text-light\">Class</label>\n" +
                "                        <select class=\"form-select\" id=\"travelClass\">\n" +
                "                            <option>Economy</option>\n" +
                "                            <option>Business</option>\n" +
                "                            <option>First Class</option>\n" +
                "                        </select>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"mt-3\">\n" +
                "                    <input type=\"checkbox\" id=\"monthSearch\">\n" +
                "                    <label class=\"text-light\">Show Monthly Fare Calendar</label>\n" +
                "                </div>\n" +
                "                <div class=\"text-center mt-4\">\n" +
                "                    <button type=\"submit\" class=\"btn btn-search\">\uD83D\uDD0D Search Flights</button>\n" +
                "                </div>\n" +
                "            </form>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "    <!-- Results Section -->\n" +
                "    <div class=\"results-container\">\n" +
                "        <h2 class=\"text-center\">Available Flights</h2>\n" +
                "        <div id=\"results\"></div>\n" +
                "    </div>\n" +
                "\n" +
                "    <!-- Monthly Fare Calendar -->\n" +
                "    <div class=\"calendar-container\">\n" +
                "        <h2 class=\"text-center\">\uD83D\uDCC5 Monthly Fare Calendar</h2>\n" +
                "        <div id=\"calendar\"></div>\n" +
                "    </div></div> </div>\n" +
                "\n" +
                "    <script src=\"script.js\"></script>";
    }
}
