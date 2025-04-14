package org.example.deeprice.view.sites;

import org.example.deeprice.view.GuiFactory;
import org.example.deeprice.view.View;
import org.example.deeprice.view.components.about.HTMLAbout;
import org.example.deeprice.view.components.account.HTMLAccount;
import org.example.deeprice.view.components.chooser.HTMLFlightchooser;
import org.example.deeprice.view.components.footer.HTMLFooter;
import org.example.deeprice.view.components.header.HTMLHeader;
import org.example.deeprice.view.components.navigation.HTMLNavigation;

/**
 *
 *
 * @author Maurice Amon
 */

public class FlightSearchDocument extends View {

    private GuiFactory factory;

    private HTMLHeader header;

    private HTMLNavigation navigation;

    private HTMLAccount account;

    private HTMLFlightchooser flightchooser;

    private HTMLFooter footer;

    public FlightSearchDocument(GuiFactory factory) {
        this.factory = factory;
    }

    @Override
    public void initializeComponents() {
        header = factory.createHTMLHeaderView();
        navigation = factory.createHTMLNavigationView();
        account = factory.createAccountView();
        flightchooser = factory.createFlightchooserView();
        footer = factory.createHTMLFooterView();
    }

    @Override
    public void prepareView() {
        view = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n";
        view += header.getHeader();
        view += "<body>\n\n";
        view += navigation.getNavigation();
        view += account.getContent();
        view += flightchooser.getContent();
        view += footer.getFooter();
        view += "</body>\n" +
                "</html>";
    }

    @Override
    public String getViewContent() {
        return view;
    }
}
