package com.letelumiere.forecast.domain.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ForecastSea {

    @JsonProperty("regId")
    private String regId;

    @JsonProperty("wf3Am")
    private String wf3Am;

    @JsonProperty("wf3Pm")
    private String wf3Pm;

    @JsonProperty("wf4Am")
    private String wf4Am;

    @JsonProperty("wf4Pm")
    private String wf4Pm;

    @JsonProperty("wf5Am")
    private String wf5Am;

    @JsonProperty("wf5Pm")
    private String wf5Pm;

    @JsonProperty("wf6Am")
    private String wf6Am;

    @JsonProperty("wf6Pm")
    private String wf6Pm;

    @JsonProperty("wf7Am")
    private String wf7Am;

    @JsonProperty("wf7Pm")
    private String wf7Pm;

    @JsonProperty("wf8")
    private String wf8;

    @JsonProperty("wf9")
    private String wf9;

    @JsonProperty("wf10")
    private String wf10;

    @JsonProperty("wh3AAm")
    private double wh3AAm;

    @JsonProperty("wh3APm")
    private double wh3APm;

    @JsonProperty("wh3BAm")
    private double wh3BAm;

    @JsonProperty("wh3BPm")
    private double wh3BPm;

    @JsonProperty("wh4AAm")
    private double wh4AAm;

    @JsonProperty("wh4APm")
    private double wh4APm;

    @JsonProperty("wh4BAm")
    private double wh4BAm;

    @JsonProperty("wh4BPm")
    private double wh4BPm;

    @JsonProperty("wh5AAm")
    private double wh5AAm;

    @JsonProperty("wh5APm")
    private double wh5APm;

    @JsonProperty("wh5BAm")
    private double wh5BAm;

    @JsonProperty("wh5BPm")
    private double wh5BPm;

    @JsonProperty("wh6AAm")
    private double wh6AAm;

    @JsonProperty("wh6APm")
    private double wh6APm;

    @JsonProperty("wh6BAm")
    private double wh6BAm;

    @JsonProperty("wh6BPm")
    private double wh6BPm;

    @JsonProperty("wh7AAm")
    private double wh7AAm;

    @JsonProperty("wh7APm")
    private double wh7APm;

    @JsonProperty("wh7BAm")
    private double wh7BAm;

    @JsonProperty("wh7BPm")
    private double wh7BPm;

    @JsonProperty("wh8A")
    private double wh8A;

    @JsonProperty("wh8B")
    private double wh8B;

    @JsonProperty("wh9A")
    private double wh9A;

    @JsonProperty("wh9B")
    private double wh9B;

    @JsonProperty("wh10A")
    private double wh10A;

    @JsonProperty("wh10B")
    private double wh10B;
}
