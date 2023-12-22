package com.letelumiere.forecast;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

import com.letelumiere.forecast.domain.openApi.OpenApiController;
import com.letelumiere.forecast.domain.openApi.OpenApiService_deprecated;
import com.letelumiere.forecast.domain.openApi.model.ApiMidGrdResponse;
import com.letelumiere.forecast.domain.openApi.model.ApiMidSeaResponse;
import com.letelumiere.forecast.domain.openApi.model.ApiShortResponse;
import com.letelumiere.forecast.domain.openApi.model.ApiUltShortResponse;
import com.letelumiere.forecast.domain.openApi.model.MidApiRequest;
import com.letelumiere.forecast.domain.openApi.model.ShortApiRequest;

@SpringBootApplication
public class ForecastApplication {


    public static void main(String[] args) {
        SpringApplication.run(ForecastApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(OpenApiService_deprecated service, OpenApiController controller) {
        return args -> {
            
            var request1 = ShortApiRequest.builder()
                .pageNo("2")
                .numOfRows("10")
                .dataType("JSON")
                .base_date("20231222") //tmcf의 YYYYMMDD는 오늘 날짜로 맞춰서 작성
                .base_time("0500")
                .nx("55")
                .ny("127")
                .build();

            var request2 = MidApiRequest.builder()
                .pageNo("1")
                .numOfRows("1")
                .dataType("JSON")
                .regId("12A20000")
                .tmFc("202312220600")    //tmcf의 YYYYMMDD는 오늘 날짜로 맞춰서 작성
                .build();

            var request3 = MidApiRequest.builder()
                .pageNo("1")
                .numOfRows("10")
                .dataType("JSON")
                .regId("11D10000")
                .tmFc("202312220600") //tmcf의 YYYYMMDD는 오늘 날짜로 맞춰서 작성
                .build();
 
            ResponseEntity<ApiShortResponse> responseEntity1 = controller.getShortAPI(request1);
            System.out.println("단기 예보 = " + responseEntity1.getBody());

            ResponseEntity<ApiUltShortResponse> responseEntity4 = controller.getUltShortAPI(request1);
            System.out.println("초단기 예보 = " + responseEntity4.getBody());

//            ResponseEntity<ApiMidSeaResponse> responseEntity2 = controller.getMidSeaAPI(request2);
//            System.out.println("중기 해상 예보 = " + responseEntity2.getBody());

//            ResponseEntity<ApiMidGrdResponse> responseEntity3 = controller.getMidGrdAPI(request3);
//            System.out.println("중기 육상 예보 = " + responseEntity3.getBody());

        };
    }
}


