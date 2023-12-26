package com.letelumiere.forecast.domain.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letelumiere.forecast.domain.data.model.ForecastGrd;

public interface LandRepository extends JpaRepository<ForecastGrd, Long>{

}
