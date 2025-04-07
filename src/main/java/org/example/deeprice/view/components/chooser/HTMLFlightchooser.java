package org.example.deeprice.view.components.chooser;

/**
 *
 * @author Maurice Amon
 */

public abstract class HTMLFlightchooser {

    protected String content;

    protected abstract void initializeContent();

    public String getContent() {
        return content;
    }
}
