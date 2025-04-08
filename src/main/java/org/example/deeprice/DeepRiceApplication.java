package org.example.deeprice;

import org.example.deeprice.commands.AmadeusFlightsAPICommand;
import org.example.deeprice.commands.GoogleFlightsApiRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeepRiceApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DeepRiceApplication.class, args);
		//GoogleFlightsApiRequest request = new GoogleFlightsApiRequest();
		AmadeusFlightsAPICommand request = new AmadeusFlightsAPICommand();
		request.execute();
		//request.searchFlights("ZRH", "DBX", "2025-06-01");
	}

}
