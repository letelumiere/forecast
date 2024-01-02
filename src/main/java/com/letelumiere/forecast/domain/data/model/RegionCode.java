package com.letelumiere.forecast.domain.data.model;

import org.hibernate.annotations.IdGeneratorType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity(name = "region_code")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegionCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", insertable = false, updatable = false)
    private String code;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mf_code", referencedColumnName = "reg_id", columnDefinition = "VARCHAR(255)")
    private MarineTimeForecast marineTimeForecast;

    @ManyToOne
    @JoinColumn(name = "wf_code", referencedColumnName = "reg_id", columnDefinition = "VARCHAR(255)")
    private WeatherForecast weatherForecast;

    @ManyToOne
    @JoinColumn(name = "rf_code", referencedColumnName = "reg_id", columnDefinition = "VARCHAR(255)")
    private RainGauge rainGauge;

}
/*
    @OneToOne
    @JoinTable(name = "tables_grd",joinColumns = @JoinColumn(name="code"), inverseJoinColumns = @JoinColumn(name = "regId"))
    private ForecastGrd forecastGrd;

    @OneToOne
    @JoinTable(name = "tables_sea",joinColumns = @JoinColumn(name="code"), inverseJoinColumns = @JoinColumn(name = "regId"))
    private ForecastSea forecastSea;
    다대일(N:1) 양방향 관계에서는 @OneToMany 어노테이션이 RainGauge 엔티티에 추가되어야 합니다.
    단방향 관계에서는 RainGauge 엔티티에 @OneToMany 어노테이션이 필요하지 않습니다.
    이 예시에서는 양방향 관계에서 mappedBy 속성을 사용하여 양방향 관계를 설정했습니다. mappedBy는 관계의 주인을 설정하는데 사용됩니다. 관계의 주인은 외래 키를 가지는 엔티티입니다.
        //1:N 테이블 연관관계시에는 List<?> classType
    */