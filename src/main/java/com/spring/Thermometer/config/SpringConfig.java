package com.spring.Thermometer.config;

import com.spring.Thermometer.repository.UserRepository;
import com.spring.Thermometer.service.UserDetailsServiceImpl;
import com.spring.Thermometer.service.UserService;
import com.spring.Thermometer.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SpringConfig {
    private final UserRepository userRepository;

    @Autowired
    public SpringConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
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
}
