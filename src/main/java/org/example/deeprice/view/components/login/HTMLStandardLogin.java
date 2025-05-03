package org.example.deeprice.view.components.login;

import org.example.deeprice.ProjectConstants;

public class HTMLStandardLogin extends HTMLLogin {

    public HTMLStandardLogin() {
        initializeContent();
    }

    @Override
    protected void initializeContent() {
        login = "<div class=\"container py-5\"><nav aria-label=\"breadcrumb\">\n" +
                "  <ol class=\"breadcrumb\">\n" +
                "    <li class=\"breadcrumb-item active\" aria-current=\"page\">" + ProjectConstants.ETERNAL_PREF_NAV + "</li>\n" +
                "  </ol>\n" +
                "</nav></div><h1 class=\"text-center\">Login</h1><div class=\"container py-5 bg-light\" style=\"border-radius: 15px;\"><form action=\"/start\" method=\"post\">\n" +
                "  <div class=\"form-group\">\n" +
                "    <label for=\"inputName\">Username</label>\n" +
                "    <input type=\"text\" class=\"form-control\" id=\"inputName\" name=\"inputName\" placeholder=\"Enter username\">\n" +
                "  </div>\n" +
                "  <div class=\"form-group\">\n" +
                "    <label for=\"inputMail\">Email address</label>\n" +
                "    <input type=\"email\" class=\"form-control\" id=\"inputMail\" name=\"inputMail\" aria-describedby=\"emailHelp\" placeholder=\"Enter email\">\n" +
                "    <small id=\"emailHelp\" class=\"form-text text-muted\">We won't share your email address</small>\n" +
                "  </div>\n" +
                "  <button type=\"submit\" class=\"btn btn-primary\">Login</button>\n" +
                "</form></div>\"";
    }


}
