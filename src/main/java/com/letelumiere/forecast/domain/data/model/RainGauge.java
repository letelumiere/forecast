package com.letelumiere.forecast.domain.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "rain_gauge")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RainGauge { //강수확률
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "reg_id", nullable = true)
    private String regId;
    private int rnSt3Am;
    private int rnSt3Pm;
    private int rnSt4Am;
    private int rnSt4Pm;
    private int rnSt5Am;
    private int rnSt5Pm;
    private int rnSt6Am;
    private int rnSt6Pm;
    private int rnSt7Am;
    private int rnSt7Pm;
    private int rnSt8;
    private int rnSt9;
    private int rnSt10;
}
