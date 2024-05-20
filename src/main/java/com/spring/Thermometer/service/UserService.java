package com.spring.Thermometer.service;

import com.spring.Thermometer.model.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
