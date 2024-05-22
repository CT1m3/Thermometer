package com.spring.Thermometer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThermometerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThermometerApplication.class, args);
	}
}

//TODO: Admin sees all temps, users only see their own
//TODO: Add searchbar to dashboard
