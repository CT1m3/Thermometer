package com.spring.Thermometer.config;

import com.spring.Thermometer.Serial.ESPSerialCommunicator;
import com.spring.Thermometer.ThermometerApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletInitializer extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ThermometerApplication.class);
	}
	@Bean
	public ESPSerialCommunicator espSerialCommunicator() {
		return new ESPSerialCommunicator("COM7", 9600);
	}

}
