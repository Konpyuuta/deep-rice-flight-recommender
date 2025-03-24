package org.example.deeprice.view.sites;

import org.example.deeprice.view.GuiFactory;
import org.example.deeprice.view.View;
import org.example.deeprice.view.components.footer.HTMLFooter;
import org.example.deeprice.view.components.header.HTMLHeader;
import org.example.deeprice.view.components.navigation.HTMLNavigation;

/** Indexsite of the project ..
 *
 * @author Maurice Amon
 */

public class StartPageDocument extends View {

    private GuiFactory factory;

    private HTMLHeader header;

    private HTMLNavigation navigation;

    private HTMLFooter footer;


    public StartPageDocument(GuiFactory factory) {
        this.factory = factory;
    }

    @Override
    public void initializeComponents() {
        header = factory.createHTMLHeaderView();
        navigation = factory.createHTMLNavigationView();
        footer = factory.createHTMLFooterView();
    }

    @Override
    public void prepareView() {
        view = "<!DOCTYPE html>\n" +
        "<html lang=\"en\">\n";
        view += header.getHeader();
        view += "<body>\n\n";
        view += navigation.getNavigation();
        view += footer.getFooter();
        view += "</body>\n" +
                "</html>";

    }

    @Override
    public String getViewContent() {
        return view;
    }
}
