package com.spring.Thermometer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThermometerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThermometerApplication.class, args);
	}
}

//TODO: Add successful register message
//TODO: Add Websockets or something similar for better dashboard temperature refreshing
//TODO: Configure status to show if device is connected and when you click it, it attempts to reconnect
//TODO: Add 3d models to project
//TODO: Admin sees all temps, users only see their own
//TODO: Add searchbar to dashboard
