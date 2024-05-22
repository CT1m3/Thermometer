package com.spring.Thermometer.controller;

import com.spring.Thermometer.Serial.ESPSerialCommunicator;
import com.spring.Thermometer.model.Temperature;
import com.spring.Thermometer.model.User;
import com.spring.Thermometer.repository.UserRepository;
import com.spring.Thermometer.service.ESPSerialService;
import com.spring.Thermometer.service.TemperatureService;
import com.spring.Thermometer.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class ThermometerController {

    @Autowired
    ESPSerialService espSerialService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Qualifier("TemperatureService")
    public TemperatureService temperatureService;

    @GetMapping("/")
    public String dashboard(Model model) {
        try {
            String[] temp = espSerialService.read().split("\\.");
            model.addAttribute("tempWhole", temp[0]);
            model.addAttribute("tempDecimal", temp[1]);
            model.addAttribute("status", "Connected");
        } catch (HeadlessException e) {
            model.addAttribute("status", "Offline");
        } catch (ArrayIndexOutOfBoundsException e){
            model.addAttribute("status", "Offline");
        } catch (NullPointerException e){
            model.addAttribute("status", "Offline");
        }
        return "dashboard";
    }
    @PostMapping("/")
    public String handleDashboardButtons(@RequestParam("action") String action, @RequestParam("tempWhole") String tempWhole,
                                         @RequestParam("tempDecimal") String tempDecimal, Model model){
        if("record".equals(action)){
            String temp = tempWhole + "." + tempDecimal;

            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = ((UserDetails)principal).getUsername();


            User currentUser = userRepository.findByUsername(username);
            try{
                Temperature temperature = new Temperature(Double.parseDouble(temp), (Double.parseDouble(temp) * 9/5) + 32, new Date());
                temperature.setUser(currentUser);
                temperatureService.save(temperature);

                return "redirect:/temperature?temp=" +temperature.getTemperatureCelsius();
            }catch (Exception e){}
        }
        if("status".equals(action)){
            espSerialService.open();
        }
        return "dashboard";
    }

    @GetMapping("/temperature")
    public String temperature(String temp, Model model){
        model.addAttribute("temp", temp);
        return "temperature";
    }

    @GetMapping("/saved")
    public String saved(@RequestParam(name = "query", required = false) String query, Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        User currentUser = userRepository.findByUsername(username);

        List<Temperature> temperatureData = null;
        try{
            if (query != null && !query.isEmpty()) {
            double temperature = Double.parseDouble(query);
            double min = temperature;
            double max = temperature + 0.5;
            if (currentUser.getRole().equals("ADMIN")){
                temperatureData = temperatureService.findByTemperatureCelsiusBetween(min, max);
            }
            if (currentUser.getRole().equals("USER")){
                temperatureData = temperatureService.findByTemperatureCelsiusBetweenAndUserId(min, max, currentUser.getId());
            }
        } else {
            if (currentUser.getRole().equals("ADMIN")) {
                temperatureData = temperatureService.getAll();
            } else {
                temperatureData = temperatureService.getByUserId(currentUser.getId());
            }
        }
            model.addAttribute("data", temperatureData);
        }catch (Exception e){}
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
        return "redirect:/view?id=" + temperature.getId();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/delete{id}")
    public String delete(@RequestParam("id") int id, Model model) {
        temperatureService.delete(id);
        return "redirect:/saved";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/view{id}")
    public String view(@RequestParam("id") int id, Model model) {
        model.addAttribute("temperature", temperatureService.getById(id));
        return "view";
    }
}
