package com.letelumiere.forecast.domain.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letelumiere.forecast.domain.data.model.ForecastGrd;

public interface VillageRepository extends JpaRepository<ForecastGrd, Long>{

}
