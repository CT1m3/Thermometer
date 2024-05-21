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
//TODO: Add keisti
//TODO: Add trinti
//TODO: Add rodyti
//TODO: Fix user restrictions in WebSecurityConfig
//TODO: Add Websockets or something similar for better dashboard temperature refreshing
//TODO: Make saved.jsp look better
//TODO: Configure status to show if device is connected and when you click it, it attempts to reconnect