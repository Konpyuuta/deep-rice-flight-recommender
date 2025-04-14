package org.example.deeprice.view;

import org.example.deeprice.view.components.account.HTMLAccount;
import org.example.deeprice.view.components.chooser.HTMLFlightchooser;
import org.example.deeprice.view.components.ephemeral.HTMLEphemeralPreferences;
import org.example.deeprice.view.components.footer.HTMLFooter;
import org.example.deeprice.view.components.header.HTMLHeader;
import org.example.deeprice.view.components.login.HTMLLogin;
import org.example.deeprice.view.components.navigation.HTMLNavigation;
import org.example.deeprice.view.components.preferences.HTMLPreferences;
import org.example.deeprice.view.components.about.HTMLAbout;
import org.example.deeprice.view.components.topn.HTMLRankingTopN;

/** Abstract factory for generating the view components of a specific site ..
 *
 * @author Maurice Amon
 */

public abstract class GuiFactory {

    /** Responsible for generating the HTML-Header of the document ..
     *
     * @return HTML-Header
     */
    public abstract HTMLHeader createHTMLHeaderView();

    public abstract HTMLNavigation createHTMLNavigationView();

    public abstract HTMLEphemeralPreferences createHTMLEphemeralPreferencesView();

    public abstract HTMLPreferences createHTMLPreferencesView();
    /** In charge of generating the HTML-Footer of the document ..
     *
     * @return HTML-Footer
     */
    public abstract HTMLFooter createHTMLFooterView();


    /** Generates the about-section of the project ..
     *
     */

    public abstract HTMLAbout createAboutView();

    public abstract HTMLFlightchooser createFlightchooserView();

    public abstract HTMLRankingTopN createRankingTopNView();

    public abstract HTMLLogin createLoginView();

    public abstract HTMLAccount createAccountView();


}
