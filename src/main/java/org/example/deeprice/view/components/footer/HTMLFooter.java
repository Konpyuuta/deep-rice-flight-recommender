package org.example.deeprice.view.components.footer;

/** An interface for all Footer designs ...
 *
 * @author Maurice Amon
 */
public abstract class HTMLFooter {

    protected String footer;

    protected abstract void addCopyright(String copyright);

    protected abstract void addContact();

    protected abstract void initialize();

    public String getFooter() {
        return footer;
    }
}
