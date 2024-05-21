package com.spring.Thermometer.controller;

import com.spring.Thermometer.Serial.ESPSerialCommunicator;
import com.spring.Thermometer.model.Temperature;
import com.spring.Thermometer.service.ESPSerialService;
import com.spring.Thermometer.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.text.SimpleDateFormat;
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
        } catch (ArrayIndexOutOfBoundsException e){
            System.err.println("No value");
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

            return "redirect:/temperature?temp=" +temperature.getTemperatureCelsius();
        }
        return "dashboard";
    }

    @GetMapping("/temperature")
    public String temperature(String temp, Model model){
        model.addAttribute("temp", temp);
        return "temperature";
    }

    @GetMapping("/saved")
    public String saved(Model model){
        model.addAttribute("data", temperatureService.getAll());
        return "saved";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    @GetMapping("/edit{id}")
    public String update(@RequestParam("id") int id, Model model){
        model.addAttribute("temperature", temperatureService.getById(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String update(@ModelAttribute("temperature") Temperature temperature){
        temperatureService.update(temperature);
        return "redirect:/saved";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/delete{id}")
    public String delete(@RequestParam("id") int id, Model model) {
        temperatureService.delete(id);
        return "redirect:/saved";
    }
}
