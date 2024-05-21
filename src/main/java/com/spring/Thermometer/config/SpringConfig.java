package com.spring.Thermometer.config;

import com.spring.Thermometer.repository.TemperatureRepository;
import com.spring.Thermometer.repository.UserRepository;
import com.spring.Thermometer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SpringConfig {
    private final UserRepository userRepository;
    private final TemperatureRepository temperatureRepository;

    @Autowired
    public SpringConfig(UserRepository userRepository, TemperatureRepository temperatureRepository) {
        this.userRepository = userRepository;
        this.temperatureRepository = temperatureRepository;
    }
    @Bean
    @Qualifier("UserDetailsService")
    public UserDetailsService getuserDetailsService() {
        return new UserDetailsServiceImpl();
    }
    @Bean
    @Qualifier("UserService")
    public UserService getUserService() {
        return new UserServiceImpl();
    }
    @Bean
    @Qualifier("TemperatureService")
    public TemperatureService getTemperatureService(){
        return new TemperatureServiceImpl();
    }
}
