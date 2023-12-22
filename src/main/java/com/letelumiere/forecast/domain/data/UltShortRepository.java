package com.letelumiere.forecast.domain.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letelumiere.forecast.domain.data.model.ForecastUltShort;


public interface UltShortRepository extends JpaRepository<ForecastUltShort, Long>{

}
