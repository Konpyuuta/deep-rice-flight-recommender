package org.example.deeprice.model.graphdb;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.QueryConfig;

import java.sql.SQLOutput;
import java.util.Map;

public class GraphDBConnector {

    final String dbUri = "bolt://localhost:7687";
    final String dbUser = "neo4j";
    final String dbPassword = "password";

    public GraphDBConnector() {
        initiateConnection();
    }

    private void initiateConnection() {
        try  {
            var driver = GraphDatabase.driver(dbUri);
            driver.verifyConnectivity();
            System.out.println("Successfully connected to Neo4j!");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
