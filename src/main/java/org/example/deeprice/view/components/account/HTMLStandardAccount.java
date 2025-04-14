package org.example.deeprice.view.components.account;

import org.example.deeprice.model.user.User;

/**
 *
 * @author Maurice Amon
 */

public class HTMLStandardAccount extends HTMLAccount {

    public HTMLStandardAccount() {
        initializeContent();
    }

    @Override
    protected void initializeContent() {
        content = "<div class=\"container py-5\"><div class=\"alert alert-info\" role=\"alert\">\n" +
                "  Logged in as <span style=\"font-weight: bold;\">" + User.getInstance().getUsername() + "</span>\n" +
                "</div></div>";
    }
}
