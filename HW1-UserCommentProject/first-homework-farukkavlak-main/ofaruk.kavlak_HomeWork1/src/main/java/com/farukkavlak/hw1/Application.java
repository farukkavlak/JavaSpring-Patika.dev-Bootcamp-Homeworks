package com.farukkavlak.hw1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@SpringBootConfiguration
@EntityScan("com.farukkavlak.hw1")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		//ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
	}

}
