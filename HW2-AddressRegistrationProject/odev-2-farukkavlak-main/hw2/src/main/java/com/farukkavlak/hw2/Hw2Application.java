package com.farukkavlak.hw2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@SpringBootConfiguration
@EntityScan("com.farukkavlak.hw2")
public class Hw2Application {

	public static void main(String[] args) {
		SpringApplication.run(Hw2Application.class, args);
	}

}
