package org.example.deeprice.view.components.ephemeral;

/**
 *
 * @author Maurice Amon
 */

public abstract class HTMLEphemeralPreferences {

    protected String content;

    protected abstract void initializeContent();

    public String getContent() {
        return content;
    }
}
