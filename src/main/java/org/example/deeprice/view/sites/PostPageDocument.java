package org.example.deeprice.view.sites;


import org.example.deeprice.view.GuiFactory;
import org.example.deeprice.view.View;
import org.example.deeprice.view.components.header.HTMLHeader;
import org.example.deeprice.view.components.footer.HTMLFooter;

import org.example.deeprice.ProjectConstants;
/**
 *
 * @author Maurice Amon
 */

public class PostPageDocument extends View {

    private GuiFactory factory;

    private HTMLHeader header;

    private HTMLFooter footer;

    public PostPageDocument(GuiFactory factory) {
        this.factory = factory;
    }

    @Override
    public void initializeComponents() {
        header = factory.createHTMLHeaderView();
        footer = factory.createHTMLFooterView();
    }

    @Override
    public void prepareView() {
        view = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n";
        view += header.getHeader();
        view += "<body>\n\n";
        view += footer.getFooter();
        view += "</body>\n" +
                "</html>";
    }

    @Override
    public String getViewContent() {
        return view;
    }
}
