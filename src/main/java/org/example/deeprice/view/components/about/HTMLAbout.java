package org.example.deeprice.view.components.about;

public abstract class HTMLAbout {

    protected String content;

    protected abstract void initializeContent();

    public String getContent() {
        return content;
    }
}
