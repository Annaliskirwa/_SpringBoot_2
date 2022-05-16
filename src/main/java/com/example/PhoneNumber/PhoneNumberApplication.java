package com.example.PhoneNumber;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "PhoneNumber API", version = "1.0", description = "Phone number endpoints documentation"))
public class PhoneNumberApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhoneNumberApplication.class, args);
	}

}
