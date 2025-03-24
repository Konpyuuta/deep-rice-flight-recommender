package org.example.deeprice;

import org.example.deeprice.commands.GoogleFlightsApiRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeepRiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeepRiceApplication.class, args);
		GoogleFlightsApiRequest request = new GoogleFlightsApiRequest();
		request.execute();
	}

}
