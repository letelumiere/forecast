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

@Entity(name = "marinetime_forecast")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MarineTimeForecast { //해고(파도 높이)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "reg_id", nullable = true)
    private String regId;
    private double wh3AAm;
    private double wh3APm;
    private double wh3BAm;
    private double wh3BPm;
    private double wh4AAm;
    private double wh4APm;
    private double wh4BAm;
    private double wh4BPm;
    private double wh5AAm;
    private double wh5APm;
    private double wh5BAm;
    private double wh5BPm;
    private double wh6AAm;
    private double wh6APm;
    private double wh6BAm;
    private double wh6BPm;
    private double wh7AAm;
    private double wh7APm;
    private double wh7BAm;
    private double wh7BPm;
    private double wh8A;    
    private double wh8B;
    private double wh9A;
    private double wh9B;
    private double wh10A;
    private double wh10B;
}
