package org.example.deeprice.view.components.header;

public abstract class HTMLHeader {

    protected String header;

    public abstract void addCharset();

    public abstract void addDependencies();

    public abstract void addTitle();

    public String getHeader() {
        return header;
    }
}
