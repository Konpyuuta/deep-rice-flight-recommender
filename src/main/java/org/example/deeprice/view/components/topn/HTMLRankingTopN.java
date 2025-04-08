package org.example.deeprice.view.components.topn;

/**
 *
 * @author Maurice Amon
 */

public abstract class HTMLRankingTopN {

    protected String content;

    protected abstract void initializeContent();

    public String getContent() {
        return content;
    }
}
