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
                "      <td><div class=\"card\" style=\"width: 70%;\"><div class=\"card-header d-flex align-items-center\">\n" +
                "               <img class=\"card-img-top\" src=\"https://pics.avs.io/200/67/VN.png\" style=\"max-height: 5%; max-width: 15%;\" alt=\"Card image cap\">\n" +
                "               <div style=\"margin-left: 5%;\"><div class=\"d-flex\">\n" +
                "      <div class=\"text-center\"><div class=\"fw-bold\"> ZRH ---> <i class=\"fas fa-plane\"></i> ---> DBX &nbsp;</div>\n" +
                "      <div class=\"text-muted small\">14:10 Emirates 23:50</div></div>\n" +
                "      <div class=\"text-center\"><div class=\"fw-bold\"> DBX ---> <i class=\"fas fa-plane\"></i> ---> SGN &nbsp;</div>\n" +
                "      <div class=\"text-muted small\">03:50 Emirates 07:05</div></div>\n" +
                "    </div></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div align=\"right\" style=\"font-weight: bold;\">Price: 578.70.- CHF</div></div>" +
                "               <div class=\"card-body\">\n" +
                "               <h5 class=\"card-title\">Flight EK817</h5>\n" +
                "               <div style=\"background-color: #d4edda; border: 1px solid green; text-align: center;\"><i class=\"fa-solid fa-circle-plus\" style=\"color: green;\"></i></div>" +
                "               <div id=\"luggage-req\"><i class=\"fa-solid fa-suitcase-rolling\"></i> This flight suits your luggage requirements.</div>" +
                "               <div id=\"food-req\"><i class=\"fas fa-utensils\"></i> Emirates is known for it's delicious meals.</div>" +
                "               <div id=\"seat-req\"><i class=\"fas fa-chair\"></i> Emirates is well-known for it's comfortable chairs.</div>" +
                "               <div id=\"legroom-req\"><i class=\"fas fa-shoe-prints\"></i> Emirates is well-known for it's generous legroom.</div>" +
                "               <div id=\"price-req\"><i class=\"fas fa-coins\"></i> Emirates is well-known for it's generous price.</div>" +
                "               <div id=\"customer-service-req\"><i class=\"fas fa-headset\"></i> Emirates is well-known for it's good customer service.</div>" +

                "               <div style=\"background-color: #f28b82; border: 1px solid darkred; text-align: center; margin-top: 5%;\"><i class=\"fa-solid fa-circle-minus\" style=\"color: darkred;\"></i></div>" +
                "               <div id=\"time-req\"><i class=\"fas fa-hourglass-half\"></i> This flight is rather long compared to other fligths.</div>" +
                "               <br/>" +
                "               <a href=\"#\" class=\"btn btn-primary\">Book Flight</a>\n" +
                "           </div>\n" +
                "</div></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <th scope=\"row\">2</th>\n" +
                "      <td><div class=\"card\" style=\"width: 50%;\"><div class=\"card-header d-flex align-items-center\">\n" +
                "               <img class=\"card-img-top\" src=\"https://pics.avs.io/200/67/EK.png\" style=\"max-height: 5%; max-width: 15%;\" alt=\"Card image cap\">\n" +
                "               <div style=\"margin-left: 5%;\"> ZRH <i class=\"fas fa-plane\"></i> SGN</div></div>" +
                "  <div class=\"card-body\">\n" +
                "    <h5 class=\"card-title\">Card title</h5>\n" +
                "    <p class=\"card-text\">Some quick example text to build on the card title and make up the bulk of the card's content.</p>\n" +
                "    <a href=\"#\" class=\"btn btn-primary\">Go somewhere</a>\n" +
                "  </div>\n" +
                "</div></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <th scope=\"row\">3</th>\n" +
                "      <td><div class=\"card\" style=\"width: 50%;\"><div class=\"card-header d-flex align-items-center\">\n" +
                "               <img class=\"card-img-top\" src=\"https://pics.avs.io/200/67/TG.png\" style=\"max-height: 5%; max-width: 15%;\" alt=\"Card image cap\">\n" +
                "               <div style=\"margin-left: 5%;\"> ZRH <i class=\"fas fa-plane\"></i> SGN</div></div>" +
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
