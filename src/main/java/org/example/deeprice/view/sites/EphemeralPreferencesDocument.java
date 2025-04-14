package org.example.deeprice.view.sites;

import org.example.deeprice.view.GuiFactory;
import org.example.deeprice.view.View;
import org.example.deeprice.view.components.account.HTMLAccount;
import org.example.deeprice.view.components.ephemeral.HTMLEphemeralPreferences;
import org.example.deeprice.view.components.footer.HTMLFooter;
import org.example.deeprice.view.components.header.HTMLHeader;
import org.example.deeprice.view.components.navigation.HTMLNavigation;

/**
 *
 *
 * @author Maurice Amon
 */

public class EphemeralPreferencesDocument extends View {

    private GuiFactory factory;

    private HTMLHeader header;

    private HTMLNavigation navigation;

    private HTMLAccount account;

    private HTMLEphemeralPreferences preferences;

    private HTMLFooter footer;

    public EphemeralPreferencesDocument(GuiFactory factory) {
        this.factory = factory;
    }
    @Override
    public void initializeComponents() {
        header = factory.createHTMLHeaderView();
        navigation = factory.createHTMLNavigationView();
        preferences = factory.createHTMLEphemeralPreferencesView();
        account = factory.createAccountView();
        footer = factory.createHTMLFooterView();
    }

    @Override
    public void prepareView() {
        view = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n";
        view += header.getHeader();
        view += "<body>\n\n";
        view += navigation.getNavigation();
        view += preferences.getContent();
        view += account.getContent();
        view += footer.getFooter();
        view += "</body>\n" +
                "</html>";
    }

    @Override
    public String getViewContent() {
        return view;
    }
}
