package org.example.deeprice.view.components.topn;

/**
 *
 * @author Maurice Amon
 */

public class HTMLStandardRankingTopN extends HTMLRankingTopN {

    public HTMLStandardRankingTopN() {
        initializeContent();
    }

    @Override
    protected void initializeContent() {
        content = "<div class=\"container py-5 bg-light\" style=\"border-radius: 15px;\"><table class=\"table\">\n" +
                "  <thead>\n" +
                "    <tr>\n" +
                "      <th scope=\"col\">#</th>\n" +
                "      <th scope=\"col\">Flight</th>\n" +
                "    </tr>\n" +
                "  </thead>\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <th scope=\"row\">1</th>\n" +
                "      <td><div class=\"card\" style=\"width: 50%;\">\n" +
                "               <img class=\"card-img-top\" src=\"...\" alt=\"Card image cap\">\n" +
                "               <div class=\"card-body\">\n" +
                "               <h5 class=\"card-title\">Card title</h5>\n" +
                "               <p class=\"card-text\">Some quick example text to build on the card title and make up the bulk of the card's content.</p>\n" +
                "               <a href=\"#\" class=\"btn btn-primary\">Go somewhere</a>\n" +
                "           </div>\n" +
                "</div></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <th scope=\"row\">2</th>\n" +
                "      <td><div class=\"card\" style=\"width: 50%;\">\n" +
                "  <img class=\"card-img-top\" src=\"...\" alt=\"Card image cap\">\n" +
                "  <div class=\"card-body\">\n" +
                "    <h5 class=\"card-title\">Card title</h5>\n" +
                "    <p class=\"card-text\">Some quick example text to build on the card title and make up the bulk of the card's content.</p>\n" +
                "    <a href=\"#\" class=\"btn btn-primary\">Go somewhere</a>\n" +
                "  </div>\n" +
                "</div></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <th scope=\"row\">3</th>\n" +
                "      <td><div class=\"card\" style=\"width: 50%;\">\n" +
                "  <img class=\"card-img-top\" src=\"...\" alt=\"Card image cap\">\n" +
                "  <div class=\"card-body\">\n" +
                "    <h5 class=\"card-title\">Card title</h5>\n" +
                "    <p class=\"card-text\">Some quick example text to build on the card title and make up the bulk of the card's content.</p>\n" +
                "    <a href=\"#\" class=\"btn btn-primary\">Go somewhere</a>\n" +
                "  </div>\n" +
                "</div></td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table></div>";
    }
}
