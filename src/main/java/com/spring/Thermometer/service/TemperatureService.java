package com.spring.Thermometer.service;

import com.spring.Thermometer.model.Temperature;

import java.util.List;

public interface TemperatureService {

    List<Temperature> getAll();

    void save(Temperature temperature);

    Temperature getById(int id);

    void update(Temperature temperature);

    void delete(int id);
}