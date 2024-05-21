package com.spring.Thermometer.controller;

import com.spring.Thermometer.Serial.ESPSerialCommunicator;
import com.spring.Thermometer.model.Temperature;
import com.spring.Thermometer.service.ESPSerialService;
import com.spring.Thermometer.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;
import java.util.Date;

@Controller
@EnableAutoConfiguration
public class ThermometerController {

    @Autowired
    ESPSerialService espSerialService;

    @Autowired
    @Qualifier("TemperatureService")
    public TemperatureService temperatureService;


    @GetMapping("/")
    public String dashboard(Model model) {
        try {
            String[] temp = espSerialService.read().split("\\.");
            model.addAttribute("tempWhole", temp[0]);
            model.addAttribute("tempDecimal", temp[1]);
        } catch (HeadlessException e) {
            System.err.println("HeadlessException triggered");
        }
        return "dashboard";
    }
    @PostMapping("/")
    public String handleDashboardButtons(@RequestParam("action") String action, @RequestParam("tempWhole") String tempWhole,
                                         @RequestParam("tempDecimal") String tempDecimal, Model model){
        if("record".equals(action)){
            String temp = tempWhole + "." + tempDecimal;
            Temperature temperature = new Temperature(Double.parseDouble(temp), (Double.parseDouble(temp) * 9/5) + 32, new Date());
            temperatureService.save(temperature);
        }
        return "dashboard";
    }

    @GetMapping("/saved")
    public String saved(Model model){
        model.addAttribute("data", temperatureService.getAll());
        return "saved";
    }
}
