package org.example.deeprice.view.sites;

import org.example.deeprice.view.GuiFactory;
import org.example.deeprice.view.View;
import org.example.deeprice.view.components.about.HTMLAbout;
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

    private HTMLAbout about;

    private HTMLFooter footer;

    @Override
    public void initializeComponents() {
        header = factory.createHTMLHeaderView();
        navigation = factory.createHTMLNavigationView();
        about = factory.createAboutView();
        footer = factory.createHTMLFooterView();
    }

    @Override
    public void prepareView() {

    }

    @Override
    public String getViewContent() {
        return "";
    }
}
