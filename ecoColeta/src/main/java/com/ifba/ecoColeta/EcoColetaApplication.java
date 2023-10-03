package com.ifba.ecoColeta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class EcoColetaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcoColetaApplication.class, args);
	}

}
