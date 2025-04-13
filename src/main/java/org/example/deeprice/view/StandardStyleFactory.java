package org.example.deeprice.view;

import org.example.deeprice.view.components.about.HTMLAbout;
import org.example.deeprice.view.components.about.HTMLStandardAbout;
import org.example.deeprice.view.components.chooser.HTMLFlightchooser;
import org.example.deeprice.view.components.chooser.HTMLStandardFlightChooser;
import org.example.deeprice.view.components.ephemeral.HTMLEphemeralPreferences;
import org.example.deeprice.view.components.ephemeral.HTMLStandardEphemeralPreferences;
import org.example.deeprice.view.components.footer.HTMLFooter;
import org.example.deeprice.view.components.footer.HTMLStandardFooterView;
import org.example.deeprice.view.components.header.HTMLStandardHeaderView;
import org.example.deeprice.view.components.header.HTMLHeader;
import org.example.deeprice.view.components.login.HTMLLogin;
import org.example.deeprice.view.components.login.HTMLStandardLogin;
import org.example.deeprice.view.components.navigation.HTMLNavigation;
import org.example.deeprice.view.components.navigation.HTMLStandardNavigationView;
import org.example.deeprice.view.components.preferences.HTMLPreferences;
import org.example.deeprice.view.components.preferences.HTMLStandardPreferences;
import org.example.deeprice.view.components.topn.HTMLRankingTopN;
import org.example.deeprice.view.components.topn.HTMLStandardRankingTopN;

/** Standard Factory for generating the GUI-Components ..
 *
 * @see GuiFactory
 *
 * @author Maurice Amon
 */

public class StandardStyleFactory extends GuiFactory {

    @Override
    public HTMLHeader createHTMLHeaderView() {
        return new HTMLStandardHeaderView();
    }

    @Override
    public HTMLNavigation createHTMLNavigationView() {
        return new HTMLStandardNavigationView();
    }

    @Override
    public HTMLEphemeralPreferences createHTMLEphemeralPreferencesView() {
        return new HTMLStandardEphemeralPreferences();
    }

    @Override
    public HTMLPreferences createHTMLPreferencesView() {
        return new HTMLStandardPreferences();
    }

    @Override
    public HTMLFooter createHTMLFooterView() {
        return new HTMLStandardFooterView();
    }

    @Override
    public HTMLAbout createAboutView() {
        return new HTMLStandardAbout();
    }

    @Override
    public HTMLFlightchooser createFlightchooserView() {
        return new HTMLStandardFlightChooser();
    }

    @Override
    public HTMLRankingTopN createRankingTopNView() {
        return new HTMLStandardRankingTopN();
    }

    @Override
    public HTMLLogin createLoginView() {
        return new HTMLStandardLogin();
    }

}
