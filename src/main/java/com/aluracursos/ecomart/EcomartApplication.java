package com.aluracursos.ecomart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcomartApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomartApplication.class, args);

		System.out.println("Inicia el chatbot con el nombre \"Ecomart\"");
		// Ejemplo: ChatClient.builder().botName("Ecomart").build().start();
		// ChatClient.builder().botName("Ecomart").build().start();
	}

}
