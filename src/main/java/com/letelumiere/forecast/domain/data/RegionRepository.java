package com.letelumiere.forecast.domain.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letelumiere.forecast.domain.data.model.RegionCode;

public interface RegionRepository extends JpaRepository<RegionCode, String>{

}
