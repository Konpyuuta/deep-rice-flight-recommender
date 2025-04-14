package org.example.deeprice.view.components.account;

/**
 *
 * @author Maurice Amon
 */

public abstract class HTMLAccount {

    protected String content;

    protected abstract void initializeContent();

    public String getContent() {
        return content;
    }
}
