package com.letelumiere.forecast;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.letelumiere.forecast.domain.data.model.MarineTimeForecast;
import com.letelumiere.forecast.domain.data.model.RainGauge;
import com.letelumiere.forecast.domain.data.model.RegionCode;
import com.letelumiere.forecast.domain.data.model.WeatherForecast;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class ForecastApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EntityManager entityManager;


    @Test
    void test1() {
        try {
            // MarineTimeForecast를 먼저 저장
            var marine = MarineTimeForecast.builder()
                .regId("12A13TEST223")
                .build();
            entityManager.persist(marine);
    
            var rf = RainGauge.builder()
                .regId("12A13TEST223")
                .build();
            entityManager.persist(rf);

            var wf = WeatherForecast.builder()
                .regId("12A13TEST223")
                .build();
            entityManager.persist(wf);

            // RegionCode를 생성하면서 앞서 저장한 MarineTimeForecast를 사용
            var regionCode = RegionCode.builder()
                .code("12A13TEST223")
                .marineTimeForecast(marine)
                .weatherForecast(wf)
                .rainGauge(rf)
                .build();

            entityManager.persist(regionCode);
            // 변경을 데이터베이스에 반영
            entityManager.flush();
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            fail("테스트 실패: " + e.getMessage());
        }
    }   
}