package com.spring.Thermometer.controller;

import com.spring.Thermometer.Serial.ESPSerialCommunicator;
import com.spring.Thermometer.service.ESPSerialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@EnableAutoConfiguration
public class ThermometerController {

    @Autowired
    ESPSerialService espSerialService;
    @Autowired
    ESPSerialCommunicator espSerialCommunicator;
    @GetMapping("/")
    public String dashboard(Model model) {
        espSerialCommunicator.init("COM7", 9600);
        model.addAttribute("temp", espSerialService.read());
        espSerialService.close();
        return "dashboard";
    }
}
