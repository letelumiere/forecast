package com.letelumiere.forecast.domain.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ForecastGrdDTO {
    private Long id;
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

    public static ForecastGrdDTO fromEntity(ForecastGrd entity) {
        return ForecastGrdDTO.builder()
                .id(entity.getId())
                .regId(entity.getRegId())
                .rnSt3Am(entity.getRnSt3Am())
                .rnSt3Pm(entity.getRnSt3Pm())
                .rnSt4Am(entity.getRnSt4Am())
                .rnSt4Pm(entity.getRnSt4Pm())
                .rnSt5Am(entity.getRnSt5Am())
                .rnSt5Pm(entity.getRnSt5Pm())
                .rnSt6Am(entity.getRnSt6Am())
                .rnSt6Pm(entity.getRnSt6Pm())
                .rnSt7Am(entity.getRnSt7Am())
                .rnSt7Pm(entity.getRnSt7Pm())
                .rnSt8(entity.getRnSt8())
                .rnSt9(entity.getRnSt9())
                .rnSt10(entity.getRnSt10())
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
                .build();
    }

    public ForecastGrd toEntity() {
        return ForecastGrd.builder()
                .id(id)
                .regId(regId)
                .rnSt3Am(rnSt3Am)
                .rnSt3Pm(rnSt3Pm)
                .rnSt4Am(rnSt4Am)
                .rnSt4Pm(rnSt4Pm)
                .rnSt5Am(rnSt5Am)
                .rnSt5Pm(rnSt5Pm)
                .rnSt6Am(rnSt6Am)
                .rnSt6Pm(rnSt6Pm)
                .rnSt7Am(rnSt7Am)
                .rnSt7Pm(rnSt7Pm)
                .rnSt8(rnSt8)
                .rnSt9(rnSt9)
                .rnSt10(rnSt10)
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
                .build();
    }
}
