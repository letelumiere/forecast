package com.letelumiere.forecast.domain.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.letelumiere.forecast.domain.data.model.ForecastSea;

public interface SeaRepository extends JpaRepository<ForecastSea, Long>{

}
