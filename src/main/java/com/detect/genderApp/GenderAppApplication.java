package com.detect.genderApp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class GenderAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenderAppApplication.class, args);
	}

}
