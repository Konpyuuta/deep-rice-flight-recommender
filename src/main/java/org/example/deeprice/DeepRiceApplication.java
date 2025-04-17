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

		/*HandleAPIRequestCommand handleAPIRequestCommand = new HandleAPIRequestCommand();
		handleAPIRequestCommand.execute();
		ArrayList<Record> records = GraphDBConnector.getInstance().executeQuery("MATCH (n) WHERE n.iata = 'EK' RETURN n");
		for(Record record : records) {
			Node n = record.get("n").asNode();
			Map<String, Object> propMap = n.asMap();
			for(Map.Entry entry : propMap.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
		}*/
		//GoogleFlightsApiRequest request = new GoogleFlightsApiRequest();
		//AmadeusFlightsAPICommand request = new AmadeusFlightsAPICommand();
		//request.execute();
		//request.searchFlights("ZRH", "DBX", "2025-06-01");
		//HandleAPIRequestCommand c = new HandleAPIRequestCommand("ZRH", "BKK", "2025-07-07", "1", 0.0, 0.0, 0.0, null);
		//c.execute();
	}

}
