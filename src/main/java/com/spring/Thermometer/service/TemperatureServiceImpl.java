package com.spring.Thermometer.service;

import com.spring.Thermometer.model.Temperature;
import com.spring.Thermometer.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureServiceImpl implements TemperatureService{

    @Autowired
    private TemperatureRepository temperatureRepository;

    @Override
    public List<Temperature> getAll(){
        return temperatureRepository.findAll();
    }
    @Override
    public void save(Temperature temperature) {
        temperatureRepository.save(temperature);
    }

    @Override
    public Temperature getById(int id) {
        return temperatureRepository.findById(id);
    }

    public List<Temperature> getByUserId(int userId){
        return temperatureRepository.findByUserId(userId);
    }

    public List<Temperature> findByTemperatureCelsiusBetween(double min, double max){ return temperatureRepository.findByTemperatureCelsiusBetween(min, max);}

    public List<Temperature> findByTemperatureCelsiusBetweenAndUserId(double min, double max, int userId){return  temperatureRepository.findByTemperatureCelsiusBetweenAndUserId(min, max, userId);}

    @Override
    public void update(Temperature temperature) {
        temperatureRepository.save(temperature);
    }

    @Override
    public void delete(int id) {
        temperatureRepository.deleteById(id);
    }
}
