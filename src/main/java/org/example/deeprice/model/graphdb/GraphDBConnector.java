package org.example.deeprice.model.graphdb;

import org.example.deeprice.ProjectConstants;
import org.neo4j.driver.*;
import org.neo4j.driver.Record;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Map;

import static org.example.deeprice.ProjectConstants.NEO4J_DB_PASSWORD;

public class GraphDBConnector {

    final String dbUri = "bolt://localhost:7687";
    final String dbUser = "neo4j";
    final String dbPassword = "password";
    private Driver driver;


    private static GraphDBConnector instance;

    private GraphDBConnector() {
        initiateConnection();
    }

    public static GraphDBConnector getInstance() {
        if (instance == null) {
            instance = new GraphDBConnector();
        }
        return instance;
    }

    private void initiateConnection() {
        try  {
            driver = GraphDatabase.driver(dbUri, AuthTokens.basic(dbUser, NEO4J_DB_PASSWORD));
            driver.verifyConnectivity();
            System.out.println("Successfully connected to Neo4j!");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Record> executeQuery(String query) {
        ArrayList<Record> records = new ArrayList<>();
        try (Session session = driver.session(SessionConfig.forDatabase(ProjectConstants.NEO4J_DB_NAME))) {
                Result result = session.run(query);
                while(result.hasNext()) {
                    Record record = result.next();
                    records.add(record);
                }
        }
        return records;

    }

}
