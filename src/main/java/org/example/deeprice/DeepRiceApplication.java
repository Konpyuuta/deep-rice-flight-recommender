package org.example.deeprice;

import org.example.deeprice.commands.api.HandleAPIRequestCommand;
import org.example.deeprice.model.graphdb.GraphDBConnector;
import org.example.deeprice.model.preferences.FlightPreferences;
import org.neo4j.driver.Record;
import org.neo4j.driver.types.Node;
import org.neo4j.driver.util.Pair;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Map;

@SpringBootApplication
public class DeepRiceApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DeepRiceApplication.class, args);
	}

}
