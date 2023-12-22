package com.letelumiere.forecast.domain.data.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ForecastShortDTO {
    private Long id;
    private String baseDate;
    private String baseTime;
    private String category;
    private String fcstDate;
    private String fcstTime;
    private String fcstValue;
    private int nx;
    private int ny;

    // 엔터티를 DTO로 변환하는 메서드
    public static ForecastShortDTO fromEntity(ForecastShort forecastShort) {
        return ForecastShortDTO.builder()
                .id(forecastShort.getId())
                .baseDate(forecastShort.getBaseDate())
                .baseTime(forecastShort.getBaseTime())
                .category(forecastShort.getCategory())
                .fcstDate(forecastShort.getFcstDate())
                .fcstTime(forecastShort.getFcstTime())
                .fcstValue(forecastShort.getFcstValue())
                .nx(forecastShort.getNx())
                .ny(forecastShort.getNy())
                .build();
    }
    public ForecastShort toEntity() {
        return ForecastShort.builder()
                .id(id)
                .baseDate(baseDate)
                .baseTime(baseTime)
                .category(category)
                .fcstDate(fcstDate)
                .fcstTime(fcstTime)
                .fcstValue(fcstValue)
                .nx(nx)
                .ny(ny)
                .build();
    }
}
