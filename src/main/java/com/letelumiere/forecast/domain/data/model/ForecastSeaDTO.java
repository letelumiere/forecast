package com.letelumiere.forecast.domain.data.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ForecastSeaDTO {
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

    public static ForecastSeaDTO fromEntity(ForecastSea entity) {
        return ForecastSeaDTO.builder()
                .id(entity.getId())
                .regId(entity.getRegId())
                .wf3Am(entity.getWf3Am())
                .wf3Pm(entity.getWf3Pm())
                .wf4Am(entity.getWf4Am())
                .wf4Pm(entity.getWf4Pm())
                .wf5Am(entity.getWf5Am())
                .wf5Pm(entity.getWf5Pm())
                .wf6Am(entity.getWf6Am())
                .wf6Pm(entity.getWf6Pm())
                .wf7Am(entity.getWf7Am())
                .wf7Pm(entity.getWf7Pm())
                .wf8(entity.getWf8())
                .wf9(entity.getWf9())
                .wf10(entity.getWf10())
                .wh3AAm(entity.getWh3AAm())
                .wh3APm(entity.getWh3APm())
                .wh3BAm(entity.getWh3BAm())
                .wh3BPm(entity.getWh3BPm())
                .wh4AAm(entity.getWh4AAm())
                .wh4APm(entity.getWh4APm())
                .wh4BAm(entity.getWh4BAm())
                .wh4BPm(entity.getWh4BPm())
                .wh5AAm(entity.getWh5AAm())
                .wh5APm(entity.getWh5APm())
                .wh5BAm(entity.getWh5BAm())
                .wh5BPm(entity.getWh5BPm())
                .wh6AAm(entity.getWh6AAm())
                .wh6APm(entity.getWh6APm())
                .wh6BAm(entity.getWh6BAm())
                .wh6BPm(entity.getWh6BPm())
                .wh7AAm(entity.getWh7AAm())
                .wh7APm(entity.getWh7APm())
                .wh7BAm(entity.getWh7BAm())
                .wh7BPm(entity.getWh7BPm())
                .wh8A(entity.getWh8A())
                .wh8B(entity.getWh8B())
                .wh9A(entity.getWh9A())
                .wh9B(entity.getWh9B())
                .wh10A(entity.getWh10A())
                .wh10B(entity.getWh10B())
                .build();
    }

    public ForecastSea toEntity() {
        return ForecastSea.builder()
                .id(id)
                .regId(regId)
                .wf3Am(wf3Am)
                .wf3Pm(wf3Pm)
                .wf4Am(wf4Am)
                .wf4Pm(wf4Pm)
                .wf5Am(wf5Am)
                .wf5Pm(wf5Pm)
                .wf6Am(wf6Am)
                .wf6Pm(wf6Pm)
                .wf7Am(wf7Am)
                .wf7Pm(wf7Pm)
                .wf8(wf8)
                .wf9(wf9)
                .wf10(wf10)
                .wh3AAm(wh3AAm)
                .wh3APm(wh3APm)
                .wh3BAm(wh3BAm)
                .wh3BPm(wh3BPm)
                .wh4AAm(wh4AAm)
                .wh4APm(wh4APm)
                .wh4BAm(wh4BAm)
                .wh4BPm(wh4BPm)
                .wh5AAm(wh5AAm)
                .wh5APm(wh5APm)
                .wh5BAm(wh5BAm)
                .wh5BPm(wh5BPm)
                .wh6AAm(wh6AAm)
                .wh6APm(wh6APm)
                .wh6BAm(wh6BAm)
                .wh6BPm(wh6BPm)
                .wh7AAm(wh7AAm)
                .wh7APm(wh7APm)
                .wh7BAm(wh7BAm)
                .wh7BPm(wh7BPm)
                .wh8A(wh8A)
                .wh8B(wh8B)
                .wh9A(wh9A)
                .wh9B(wh9B)
                .wh10A(wh10A)
                .wh10B(wh10B)
                .build();
    }
}