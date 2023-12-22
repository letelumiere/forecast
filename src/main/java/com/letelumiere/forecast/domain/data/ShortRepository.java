package com.letelumiere.forecast.domain.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letelumiere.forecast.domain.data.model.ForecastShort;

public interface ShortRepository extends JpaRepository<ForecastShort, Long>{

}
