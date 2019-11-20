package com.aeo.server.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.aeo"})
public class AeoServicesTestsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AeoServicesTestsApplication.class, args);
	}

}
