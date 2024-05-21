package com.spring.Thermometer.controller;

import com.spring.Thermometer.model.User;
import com.spring.Thermometer.repository.UserRepository;
import com.spring.Thermometer.service.UserService;
import com.spring.Thermometer.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    private final UserService userService;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserController(@Qualifier("UserService") UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userForm", new User());
        return "register";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        } else {
            userService.save(userForm);
            return "redirect:/login";
        }
    }
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("userForm", new User());
        return "login";
    }
    @PostMapping("/loginUser")
    public String loginUser(@ModelAttribute("user") User loginUser, BindingResult result, RedirectAttributes redirectAttributes) {

        userValidator.validate(loginUser, result);

        if (result.hasErrors()) {
            redirectAttributes.addAttribute("error", "true");
            return "redirect:/login";
        }

        return "redirect:/dashboard";
    }

}