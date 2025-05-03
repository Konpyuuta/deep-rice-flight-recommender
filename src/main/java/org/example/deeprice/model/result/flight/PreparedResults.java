package org.example.deeprice.model.result.flight;

import java.util.ArrayList;

/**
 *
 * @author Maurice Amon
 */

public class PreparedResults {

    private String mainAirline;

    private String amountOfAirlines;

    private ArrayList<String> partialFlights;

    private String price;

    private ArrayList<String> advantageList;

    private ArrayList<String> disadvantageList;

    private String offerLink;


    public PreparedResults(String mainAirline, String amountOfAirlines, ArrayList<String> partialFlights, String price, ArrayList<String> advantageList, ArrayList<String> disadvantageList, String offerLink) {
        this.mainAirline = mainAirline;
        this.amountOfAirlines = amountOfAirlines;
        this.partialFlights = partialFlights;
        this.price = price;
        this.advantageList = advantageList;
        this.disadvantageList = disadvantageList;
        this.offerLink = offerLink;
    }

    public String getMainAirline() {
        return mainAirline;
    }

    public void setMainAirline(String mainAirline) {
        this.mainAirline = mainAirline;
    }

    public String getAmountOfAirlines() {
        return amountOfAirlines;
    }

    public ArrayList<String> getPartialFlights() {
        return partialFlights;
    }

    public ArrayList<String> getAdvantageList() {
        return advantageList;
    }

    public ArrayList<String> getDisadvantageList() {
        return disadvantageList;
    }

    public String getPrice() {
        return price;
    }

    public String getOfferLink() {
        return offerLink;
    }
}
