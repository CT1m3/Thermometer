package com.spring.Thermometer.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@EnableAutoConfiguration
public class ThermometerController {
    @GetMapping("/")
    public String dashboard() {
        return "dashboard";  // Return the name of the JSP file
    }
}
