package org.example.deeprice.commands.api;

import org.example.deeprice.commands.Command;
import org.example.deeprice.model.graphdb.GraphDBConnector;
import org.neo4j.driver.Record;

import java.util.ArrayList;

/**
 *
 * @author Maurice Amon
 */

public class FetchAirlineRatingsCommand implements Command {

    private final String airlineIata;

    private GraphDBConnector graphDBConnector;

    public FetchAirlineRatingsCommand(String airlineIata) {
        this.airlineIata = airlineIata;
    }

    @Override
    public void execute() {
        String query = "MATCH (n) WHERE n.iata = '" + airlineIata  + "' RETURN n";
        ArrayList<Record> records = GraphDBConnector.getInstance().executeQuery(query);
    }
}
