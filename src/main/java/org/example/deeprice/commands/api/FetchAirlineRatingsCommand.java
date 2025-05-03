package org.example.deeprice.commands.api;

import org.example.deeprice.commands.Command;
import org.example.deeprice.model.graphdb.GraphDBConnector;
import org.neo4j.driver.Record;
import org.neo4j.driver.types.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Maurice Amon
 */

public class FetchAirlineRatingsCommand implements Command {

    private final String airlineIata;

    private GraphDBConnector graphDBConnector;

    private Map<String, Object> nodePropertyMap;
    public FetchAirlineRatingsCommand(String airlineIata) {
        this.airlineIata = airlineIata;
    }

    @Override
    public void execute() {
        String query = "MATCH (n) WHERE n.iata = '" + airlineIata  + "' RETURN n";
        ArrayList<Record> records = GraphDBConnector.getInstance().executeQuery(query);
        for(Record record : records) {
            Node n = record.get("n").asNode();
            nodePropertyMap = n.asMap();
        }
    }

    public Map<String, Object> getNodePropertyMap() {
        return nodePropertyMap;
    }
}
