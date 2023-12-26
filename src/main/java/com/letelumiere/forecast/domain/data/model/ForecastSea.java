package com.letelumiere.forecast.domain.data.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "forecast_sea")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ForecastSea {

    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String regId;
    private String wf3Am;
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
