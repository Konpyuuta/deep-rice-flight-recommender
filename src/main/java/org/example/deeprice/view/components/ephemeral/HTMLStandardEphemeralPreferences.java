package org.example.deeprice.view.components.ephemeral;

/**
 *
 * @author Maurice Amon
 */

public class HTMLStandardEphemeralPreferences extends HTMLEphemeralPreferences {

    public HTMLStandardEphemeralPreferences() {
        initializeContent();
    }

    @Override
    protected void initializeContent() {
        content = "<h1 class=\"text-center\">Ephemeral Preferences</h1>\n" +
                "<div class=\"container py-5 bg-light\" style=\"border-radius: 15px;\">\n" +
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
