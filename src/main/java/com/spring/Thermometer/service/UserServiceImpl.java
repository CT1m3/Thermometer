package com.spring.Thermometer.service;

import com.spring.Thermometer.model.User;
import com.spring.Thermometer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    @Qualifier("BCryptPasswordEncoder")
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole("USER"); //Sets new user role to "USER" by default
        userRepository.save(user);
    }
    @Override
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

}
