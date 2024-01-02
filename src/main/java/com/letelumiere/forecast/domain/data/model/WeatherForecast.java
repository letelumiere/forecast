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

@Entity(name = "weather_forecast")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherForecast {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "reg_id", nullable = true)
    private String regId;
    private String wf3Am;       //Weahter Forecast / afterday / times
    private String wf3Pm;
    private String wf4Am;
    private String wf4Pm;
    private String wf5Am;
    private String wf5Pm;
    private String wf6Am;
    private String wf6Pm;
    private String wf7Am;
    private String wf7Pm;
    private String wf8;
    private String wf9;
    private String wf10;
}
