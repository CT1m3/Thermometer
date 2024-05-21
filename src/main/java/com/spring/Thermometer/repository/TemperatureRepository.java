package com.spring.Thermometer.repository;

import com.spring.Thermometer.model.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TemperatureRepository extends JpaRepository<Temperature, Integer> {
    @Query("select n from Temperature n where n.id = :id")
    Temperature findById(int id);
}
