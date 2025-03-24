package org.example.deeprice.view;

public abstract class View {

    protected String view;

    public abstract void initializeComponents();

    public abstract void prepareView();

    public abstract String getViewContent();
}
