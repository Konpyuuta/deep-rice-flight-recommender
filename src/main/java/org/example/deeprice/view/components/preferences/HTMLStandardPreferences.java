package org.example.deeprice.view.components.preferences;

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
        form += "<h1 class=\"text-center\">Preferences</h1>\n" +
                "<div class=\"container py-5 bg-light\" style=\"border-radius: 15px;\">\n" +
                "    <label for=\"flight-time-range\" class=\"form-label\">How important is the flight time to me when booking a flight?</label>\n" +
                "    <input type=\"range\" class=\"form-range\" min=\"1\" max=\"5\" id=\"flight-time-range\">\n" +
                "    <br>\n" +
                "    <br>\n" +
                "    <label for=\"price-ratio\" class=\"form-label\">How important is the price of a flight comparing to the service and\n" +
                "        convenience of it?</label>\n" +
                "    <input type=\"range\" class=\"form-range\" min=\"1\" max=\"5\" id=\"price-ratio\">\n" +
                "    <br><br>\n" +
                "    <label for=\"height\" class=\"form-label\">How tall are you?</label>\n" +
                "    <div class=\"input-group mb-3\">\n" +
                "        <div class=\"input-group-prepend\">\n" +
                "            <button class=\"btn btn-outline-secondary dropdown-toggle\" id=\"height\" type=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">In cm</button>\n" +
                "            <div class=\"dropdown-menu\">\n" +
                "                <a class=\"dropdown-item\" href=\"#\">In feet</a>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <input type=\"text\" class=\"form-control\" aria-label=\"Your height with different metric options\">\n" +
                "    </div>\n" +
                "    <br>\n" +
                "    <label class=\"form-label\">Preferences regarding food or dietary eating plans.</label>\n" +
                "    <div class=\"form-check\" >\n" +
                "        <input class=\"form-check-input\" type=\"checkbox\" value=\"\" id=\"flexCheckDisabled\">\n" +
                "        <label class=\"form-check-label\" for=\"flexCheckDisabled\">\n" +
                "            Kosher Meal\n" +
                "        </label>\n" +
                "    </div>\n" +
                "    <div class=\"form-check\">\n" +
                "        <input class=\"form-check-input\" type=\"checkbox\" value=\"\" id=\"flexCheckCheckedDisabled\">\n" +
                "        <label class=\"form-check-label\" for=\"flexCheckCheckedDisabled\">\n" +
                "            Non‑Vegetarian Hindu Meal\n" +
                "        </label>\n" +
                "    </div>\n" +
                "    <div class=\"form-check\">\n" +
                "        <input class=\"form-check-input\" type=\"checkbox\" value=\"\" id=\"veg\">\n" +
                "        <label class=\"form-check-label\" for=\"flexCheckCheckedDisabled\">\n" +
                "            Indian Vegetarian Meal (AVML)\n" +
                "        </label>\n" +
                "    </div>\n" +
                "    <div class=\"form-check\">\n" +
                "        <input class=\"form-check-input\" type=\"checkbox\" value=\"\" id=\"vegan\">\n" +
                "        <label class=\"form-check-label\" for=\"flexCheckCheckedDisabled\">\n" +
                "            Vegan Meal\n" +
                "        </label>\n" +
                "    </div>\n" +
                "    <div class=\"form-check\">\n" +
                "        <input class=\"form-check-input\" type=\"checkbox\" value=\"\" id=\"low-fat\">\n" +
                "        <label class=\"form-check-label\" for=\"flexCheckCheckedDisabled\">\n" +
                "            Low Fat Meal\n" +
                "        </label>\n" +
                "    </div>\n" +
                "    <div class=\"form-check\">\n" +
                "        <input class=\"form-check-input\" type=\"checkbox\" value=\"\" id=\"no-pref\">\n" +
                "        <label class=\"form-check-label\" for=\"flexCheckCheckedDisabled\">\n" +
                "            No preference\n" +
                "        </label>\n" +
                "    </div>\n" +
                "    <br>\n" +
                "    <label for=\"luggage-weight\" class=\"form-label\">How much does your luggage weight?</label>\n" +
                "    <div class=\"input-group mb-3\">\n" +
                "        <div class=\"input-group-prepend\">\n" +
                "            <button class=\"btn btn-outline-secondary dropdown-toggle\" id=\"luggage-weight\" type=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">In Kg</button>\n" +
                "            <div class=\"dropdown-menu\">\n" +
                "                <a class=\"dropdown-item\" href=\"#\">In Lb</a>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <input type=\"text\" class=\"form-control\" aria-label=\"Your height with different metric options\">\n" +
                "    </div>\n" +
                "    <br>\n" +
                "    <label class=\"form-label\">Which airlines do you prefer?</label>\n" +
                "    <div class=\"form-check\">\n" +
                "        <input class=\"form-check-input\" type=\"checkbox\" value=\"\" id=\"nippon\">\n" +
                "        <label class=\"form-check-label\" for=\"flexCheckCheckedDisabled\">\n" +
                "            Nippon Airline\n" +
                "        </label>\n" +
                "    </div>\n" +
                "    <div class=\"form-check\">\n" +
                "        <input class=\"form-check-input\" type=\"checkbox\" value=\"\" id=\"singapore\">\n" +
                "        <label class=\"form-check-label\" for=\"flexCheckCheckedDisabled\">\n" +
                "            Singapore Airline\n" +
                "        </label>\n" +
                "    </div>\n" +
                "    <div class=\"form-check\">\n" +
                "        <input class=\"form-check-input\" type=\"checkbox\" value=\"\" id=\"viet\">\n" +
                "        <label class=\"form-check-label\" for=\"flexCheckCheckedDisabled\">\n" +
                "            Vietnam Airways\n" +
                "        </label>\n" +
                "    </div>\n" +
                "    <div class=\"form-check\">\n" +
                "        <input class=\"form-check-input\" type=\"checkbox\" value=\"\" id=\"air-india\">\n" +
                "        <label class=\"form-check-label\" for=\"flexCheckCheckedDisabled\">\n" +
                "            Air India\n" +
                "        </label>\n" +
                "    </div>\n" +
                "    <div class=\"form-check\">\n" +
                "        <input class=\"form-check-input\" type=\"checkbox\" value=\"\" id=\"others\">\n" +
                "        <label class=\"form-check-label\" for=\"flexCheckCheckedDisabled\">\n" +
                "            ...\n" +
                "        </label>\n" +
                "    </div>\n" +
                "    <br>\n" +
                "    <hr/>\n" +
                "    <br>\n" +
                "    <button type=\"button\" class=\"btn btn-primary\">Save preferences</button>\n" +
                "</div>";
    }
}
