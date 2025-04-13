package org.example.deeprice.view.components.header;


import org.example.deeprice.ProjectConstants;

/** Standard HTML-header
 *
 * @author Maurice Amon
 */

public class HTMLStandardHeaderView extends HTMLHeader {

    public HTMLStandardHeaderView() {
        header = "<head>\n";
        addCharset();
        addDependencies();
        addTitle();
        header += "</head>\n";
    }


    @Override
    public void addCharset() {
        header += "<meta charset=" + "\"" + ProjectConstants.CHAR_SET + "\">\n";
    }

    @Override
    public void addDependencies() {
        header += "<link rel=\"stylesheet\" href=\"" + ProjectConstants.BOOTSTRAP_CSS_DEPENDENCY + "\" " +
                "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
                "    <link th:href=\"@{/css/style.css}\" rel=\"stylesheet\" type=\"text/css\">\n" +
                "    <script src=\"" + ProjectConstants.BOOTSTRAP_JAVASCRIPT_DEPENDENCY + "\" " +
                " integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n" +
                "<link rel=\"icon\" href=\"https://www.zhaw.ch/favicon.ico\" type=\"image/png\">" +
                "<link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css\" rel=\"stylesheet\">\n";
    }

    @Override
    public void addTitle() {
        header += "<title>" + ProjectConstants.MAIN_PAGE_TITLE + "</title>";
    }
}
