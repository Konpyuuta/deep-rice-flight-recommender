package org.example.deeprice.view.sites;

import org.example.deeprice.view.GuiFactory;
import org.example.deeprice.view.View;
import org.example.deeprice.view.components.account.HTMLAccount;
import org.example.deeprice.view.components.footer.HTMLFooter;
import org.example.deeprice.view.components.header.HTMLHeader;
import org.example.deeprice.view.components.navigation.HTMLNavigation;
import org.example.deeprice.view.components.topn.HTMLRankingTopN;

/**
 *
 * @author Maurice Amon
 */

public class RankingDocument extends View {

    private GuiFactory factory;

    private HTMLHeader header;

    private HTMLAccount account;

    private HTMLRankingTopN topN;

    private HTMLFooter footer;

    public RankingDocument(GuiFactory factory) {
        this.factory = factory;
    }

    @Override
    public void initializeComponents() {
        header = factory.createHTMLHeaderView();
        account = factory.createAccountView();
        topN = factory.createRankingTopNView();
        footer = factory.createHTMLFooterView();
    }

    @Override
    public void prepareView() {
        view = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n";
        view += header.getHeader();
        view += "<body>\n\n";
        view += account.getContent();
        view += topN.getContent();
        view += footer.getFooter();
        view += "</body>\n" +
                "</html>";
    }

    @Override
    public String getViewContent() {
        return view;
    }
}
