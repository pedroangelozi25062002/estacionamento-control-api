package com.api.estacionamento;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EstacionamentoControlApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(EstacionamentoControlApplication.class, args);
	
	}
}
