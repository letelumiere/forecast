package com.letelumiere.forecast.domain.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letelumiere.forecast.domain.data.model.MarineTimeForecast;

public interface MarineRepository extends JpaRepository<MarineTimeForecast, Long>{

}
