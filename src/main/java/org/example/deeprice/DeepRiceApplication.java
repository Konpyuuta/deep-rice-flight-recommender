package org.example.deeprice;

import org.example.deeprice.commands.SkyScannerApiRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeepRiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeepRiceApplication.class, args);
		SkyScannerApiRequest request = new SkyScannerApiRequest();
		request.execute();
	}

}
