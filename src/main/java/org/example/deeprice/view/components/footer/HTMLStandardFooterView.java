package org.example.deeprice.view.components.footer;


import org.example.deeprice.ProjectConstants;

/**
 *
 * @author Maurice Amon
 */

public class HTMLStandardFooterView extends HTMLFooter {

    public HTMLStandardFooterView() {
        initialize();
        //addCopyright(ProjectConstants.PROJECT_AUTHOR);
        //addContact();
    }

    @Override
    public void addCopyright(String copyright) {
    }

    @Override
    public void addContact() {
    }

    @Override
    protected void initialize() {
        footer = "\n" +
                "<div class=\"container\">\n" +
                "  <footer class=\"py-3 my-4\">\n" +
                "    <ul class=\"nav justify-content-center border-bottom pb-3 mb-3\">\n" +
                "      <li class=\"nav-item\"><a href=\"#\" class=\"nav-link px-2 text-muted\">Home</a></li>\n" +
                "      <li class=\"nav-item\"><a href=\"#\" class=\"nav-link px-2 text-muted\">Wiki</a></li>\n" +
                "      <li class=\"nav-item\"><a href=\"#\" class=\"nav-link px-2 text-muted\">About</a></li>\n" +
                "    </ul>\n" +
                "    <p class=\"text-center text-muted\">&copy; " + ProjectConstants.CURRENT_YEAR + " | " + ProjectConstants.PROJECT_AUTHOR + " | " + "M. Sc. Seminar in Social Computing</p>\n" +
                "  </footer>\n" +
                "</div>\n" +
                "\n" +
                "<div class=\"b-example-divider\"></div>";
    }

}
