package com.tarun.DigitalLibarary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.tarun.DigitalLibarary")
public class DigitalLibararyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalLibararyApplication.class, args);		
	}

}
