package org.example.deeprice.view.components.navigation;

import org.example.deeprice.ProjectConstants;

public class HTMLStandardNavigationView extends HTMLNavigation {

    public HTMLStandardNavigationView() {
        generateNavigation();
    }

    private void generateNavigation() {
        navigation = "<div class=\"container py-5\"><nav aria-label=\"breadcrumb\">\n" +
                "  <ol class=\"breadcrumb\">\n" +
                "    <li class=\"breadcrumb-item active\" aria-current=\"page\">" + ProjectConstants.ETERNAL_PREF_NAV + "</li>\n" +
                "    <li class=\"breadcrumb-item\"><a href=\"#\">Flightsearch</a></li>\n" +
                "    <li class=\"breadcrumb-item\" aria-current=\"page\">Ephemeral Preferences</li>   " +
                "  </ol>\n" +
                "</nav></div>";
    }
}

