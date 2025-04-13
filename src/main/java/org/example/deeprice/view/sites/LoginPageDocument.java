package org.example.deeprice.view.sites;

import org.example.deeprice.view.GuiFactory;
import org.example.deeprice.view.View;
import org.example.deeprice.view.components.footer.HTMLFooter;
import org.example.deeprice.view.components.header.HTMLHeader;
import org.example.deeprice.view.components.login.HTMLLogin;
import org.example.deeprice.view.components.navigation.HTMLNavigation;

/**
 *
 *
 * @author Maurice Amon
 */

public class LoginPageDocument extends View {

    private GuiFactory factory;

    private HTMLHeader header;

    private HTMLNavigation navigation;

    private HTMLLogin login;

    private HTMLFooter footer;

    public LoginPageDocument(GuiFactory factory) {
        this.factory = factory;
    }

    @Override
    public void initializeComponents() {
        header = factory.createHTMLHeaderView();
        navigation = factory.createHTMLNavigationView();
        login = factory.createLoginView();
        footer = factory.createHTMLFooterView();
    }

    @Override
    public void prepareView() {
        view = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n";
        view += header.getHeader();
        view += "<body>\n\n";
        view += navigation.getNavigation();
        view += login.getLogin();
        view += footer.getFooter();
        view += "</body>\n" +
                "</html>";
    }

    @Override
    public String getViewContent() {
        return view;
    }
}
