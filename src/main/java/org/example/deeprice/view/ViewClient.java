package org.example.deeprice.view;

import org.example.deeprice.view.sites.*;

/** Singleton for accessing View-components ...
 *
 * @author Maurice Amon
 */

public class ViewClient {

    private static ViewClient viewClient;

    private GuiFactory factory = new StandardStyleFactory();

    private ViewClient() {

    }

    public static ViewClient getViewClientInstance() {
        if (viewClient == null) {
            viewClient = new ViewClient();
        }
        return viewClient;
    }

    /** Creates the desired web-document ..
     *
     * @param webpage
     * @return view
     */

    public View createWebpage(Webpage webpage) {
        View view;
        switch (webpage) {
            case MAIN_PAGE:
                view = new StartPageDocument(factory);
                break;
            case ETERNAL_PREF_PAGE:
                view = new EternalPreferencesDocument(factory);
                break;
            case ABOUT_PAGE:
                view = new AboutPageDocument(factory);
                break;
            case EPHEMERAL_PREF_PAGE:
                view = new EphemeralPreferencesDocument(factory);
                break;
            case FLIGHT_SEARCH_PAGE:
                view = new FlightSearchDocument();
            default:
                view = new StartPageDocument(factory);
        }
        view.initializeComponents();
        view.prepareView();
        return view;
    }



}
