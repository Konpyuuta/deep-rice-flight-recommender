package org.example.deeprice.model.result.flight;

import org.example.deeprice.model.AirlinesMap;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maurice Amon
 */

public class FlightJourney {

    private String journeyId;

    private List<FlightItinerary> flightItineraries = new ArrayList<>();

    private Double price;

    private AllowedLuggage allowedLuggage;

    private Double totalJourneyTime;

    private Double timeSD;

    private Double priceSD;

    public FlightJourney(String journeyId, List<FlightItinerary> flightItineraries, Double price) {
        this.journeyId = journeyId;
        this.flightItineraries = flightItineraries;
        this.price = price;
    }

    public FlightJourney() {

    }

    public void setTotalJourneyTime(Double totalJourneyTime) {
        this.totalJourneyTime = totalJourneyTime;
    }

    public Double getTotalJourneyTime() {
        return totalJourneyTime;
    }

    public void setAllowedLuggage(AllowedLuggage allowedLuggage) {
        this.allowedLuggage = allowedLuggage;
    }

    public AllowedLuggage getAllowedLuggage() {
        return allowedLuggage;
    }

    public void setFlightItineraries(List<FlightItinerary> flightItineraries) {
        this.flightItineraries = flightItineraries;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setJourneyId(String journeyId) {
        this.journeyId = journeyId;
    }

    public String getJourneyId() {
        return journeyId;
    }

    public List<FlightItinerary> getFlightItineraries() {
        return flightItineraries;
    }

    public void addFlightItinerary(FlightItinerary flightItinerary) {
        flightItineraries.add(flightItinerary);
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        /*ratings[0] = Float.valueOf(airlineProps.get("food").toString())/5;
        ratings[1] = Float.valueOf(airlineProps.get("customerService").toString())/5;
        ratings[2] = Float.valueOf(airlineProps.get("seatComfort").toString())/5;
        ratings[3] = Float.valueOf(airlineProps.get("legroom").toString())/5;*/
        String airlineCode = flightItineraries.get(0).getFlights().get(0).getCarrierCode();
        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"card\" style=\"width: 100%;\"><div class=\"card-header d-flex align-items-center\">\n" +
                "               <img class=\"card-img-top\" src=\"https://pics.avs.io/200/67/" + airlineCode + ".png\" style=\"max-height: 5%; max-width: 15%;\" alt=\"Card image cap\">\n" +
                "               <div style=\"margin-left: 5%;\"><div class=\"d-flex\">\n");
        for(FlightItinerary flights : flightItineraries) {
            sb.append("<div class=\"text-center\"><div class=\"fw-bold\"> ");
            for(Flight flight : flights.getFlights()) {
                sb.append(flight.getDepartureAirport().getAirportID() + " ---> <i class=\"fas fa-plane\"></i> ---> " + flight.getArrivalAirport().getAirportID() + " &nbsp; | &nbsp; ");
            }
            sb.append("</div>");
            sb.append("<div class=\"text-muted small\">");
            for(Flight flight : flights.getFlights()) {
                sb.append(flight.getDepartureTime() + " " + AirlinesMap.IATA_AIRLINES_MAP.get(flight.getCarrierCode()) + " " + flight.getArrivalTime() + "&nbsp;&nbsp;&nbsp;");
            }
            sb.append("</div></div></div></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div align=\"right\" style=\"font-weight: bold;\">");
            if(priceSD >= 0.5) {
                sb.append("Price: " + price + ".- CHF<div><i class=\"fas fa-triangle-exclamation\" style=\"color: red;\"></i> - Expensive!</div>");
            } else if(priceSD <= -0.5) {
                sb.append("Price: " + price + ".- CHF<div><i class=\"fas fa-face-smile\"></i> - Low Price!</div>");
            } else {
                sb.append("Price: " + price + ".- CHF<div><i class=\"fas fa-face-meh\"></i> - Normal Price.</div>");
            }
            sb.append("</div></div><div class=\"card-body\">\n");
            for (Flight flight : flights.getFlights()) {
                sb.append(
                        "               <h5 class=\"card-title\">Flight " + flight.getFlightId() + ": " + flight.getDepartureAirport().getAirportID() + " ---> <i class=\"fas fa-plane\"></i> ---> " + flight.getArrivalAirport().getAirportID() + " &nbsp;</h5>\n" +
                        "               <div style=\"background-color: #d4edda; border: 1px solid green; text-align: center;\"><i class=\"fa-solid fa-circle-plus\" style=\"color: green;\"></i></div>");
                for (int i = 0; i < flight.getRatings().length; i++) {
                    if (i == 0 && flight.getRatings()[i] > 0) {
                        sb.append("<div id=\"food-req\"><i class=\"fas fa-utensils\"></i> " + AirlinesMap.IATA_AIRLINES_MAP.get(flight.getCarrierCode()) + " is known for it's delicious meals.</div>");
                    }
                    if (i == 1 && flight.getRatings()[i] > 0) {
                        sb.append("<div id=\"customer-service-req\"><i class=\"fas fa-headset\"></i> " + AirlinesMap.IATA_AIRLINES_MAP.get(flight.getCarrierCode()) + " is well-known for it's good customer service.</div>");
                    }
                    if (i == 2 && flight.getRatings()[i] > 0) {
                        sb.append("<div id=\"seat-req\"><i class=\"fas fa-chair\"></i> " + AirlinesMap.IATA_AIRLINES_MAP.get(flight.getCarrierCode()) + " is well-known for it's comfortable chairs.</div>");
                    }
                    if (i == 3 && flight.getRatings()[i] > 0) {
                        sb.append("<div id=\"legroom-req\"><i class=\"fas fa-shoe-prints\"></i> " + AirlinesMap.IATA_AIRLINES_MAP.get(flight.getCarrierCode()) + " is well-known for it's generous legroom.</div>");
                    }
                }
                sb.append("<div style=\"background-color: #f28b82; border: 1px solid darkred; text-align: center; margin-top: 5%;\"><i class=\"fa-solid fa-circle-minus\" style=\"color: darkred;\"></i></div>");

                for (int i = 0; i < flight.getRatings().length; i++) {
                    if (i == 0 && flight.getRatings()[i] < 0) {
                        sb.append("<div id=\"food-req\"><i class=\"fas fa-utensils\"></i> " + AirlinesMap.IATA_AIRLINES_MAP.get(flight.getCarrierCode()) + " does maybe not meet your requirements, as the the food there is not highly viewed by customers.</div>");
                    }
                    if (i == 1 && flight.getRatings()[i] < 0) {
                        sb.append("<div id=\"customer-service-req\"><i class=\"fas fa-headset\"></i> " + AirlinesMap.IATA_AIRLINES_MAP.get(flight.getCarrierCode()) + " is <span style=\"font-weight: bold;\">not</span> well-known for it's good customer service.</div>");
                    }
                    if (i == 2 && flight.getRatings()[i] < 0) {
                        sb.append("<div id=\"seat-req\"><i class=\"fas fa-chair\"></i> " + AirlinesMap.IATA_AIRLINES_MAP.get(flight.getCarrierCode()) + " is <span style=\"font-weight: bold;\">not</span> well-known for it's comfortable chairs.</div>");
                    }
                    if (i == 3 && flight.getRatings()[i] < 0) {
                        sb.append("<div id=\"legroom-req\"><i class=\"fas fa-shoe-prints\"></i> " + AirlinesMap.IATA_AIRLINES_MAP.get(flight.getCarrierCode()) + " is <span style=\"font-weight: bold;\">not</span> well-known for it's legroom.</div>");
                    }
                }
                sb.append("<br>");
            }
        }
        sb.append("<br><a href=\"#\" class=\"btn btn-primary\">Book Flight</a>\n" +
                "           </div>\n" +
                "</div></div>");
        /*for(FlightItinerary itinerary : flightItineraries) {
            sb.append(itinerary.toString() + "\n");
        }*/
        return sb.toString();
    }

    public void setTimeSD(Double timeSD) {
        this.timeSD = timeSD;
    }

    public void setPriceSD(Double priceSD) {
        this.priceSD = priceSD;
    }
}
