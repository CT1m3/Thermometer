package com.spring.Thermometer.repository;

import com.spring.Thermometer.model.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TemperatureRepository extends JpaRepository<Temperature, Integer> {
    @Query("select n from Temperature n where n.id = :id")
    Temperature findById(int id);
    @Query("SELECT t FROM Temperature t JOIN t.user u WHERE u.id = :userId")
    List<Temperature> findByUserId(int userId);
    List<Temperature> findByTemperatureCelsiusBetween(double min, double max);

    List<Temperature> findByTemperatureCelsiusBetweenAndUserId(double min, double max, int userId);
}
