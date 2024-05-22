package com.spring.Thermometer.service;

import com.spring.Thermometer.model.Temperature;

import java.util.List;

public interface TemperatureService {

    List<Temperature> getAll();

    void save(Temperature temperature);

    Temperature getById(int id);

    List<Temperature> getByUserId(int userId);
    List<Temperature> findByTemperatureCelsiusBetween(double min, double max);

    List<Temperature> findByTemperatureCelsiusBetweenAndUserId(double min, double max, int userId);

    void update(Temperature temperature);

    void delete(int id);

}
