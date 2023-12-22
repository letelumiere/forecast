package com.letelumiere.forecast.domain.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ForecastUltShortDTO {
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
    public static ForecastUltShortDTO fromEntity(ForecastUltShort forecastUltShort) {
        return ForecastUltShortDTO.builder()
                .id(forecastUltShort.getId())
                .baseDate(forecastUltShort.getBaseDate())
                .baseTime(forecastUltShort.getBaseTime())
                .category(forecastUltShort.getCategory())
                .fcstDate(forecastUltShort.getFcstDate())
                .fcstTime(forecastUltShort.getFcstTime())
                .fcstValue(forecastUltShort.getFcstValue())
                .nx(forecastUltShort.getNx())
                .ny(forecastUltShort.getNy())
                .build();
    }
    public ForecastUltShort toEntity() {
        return ForecastUltShort.builder()
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
