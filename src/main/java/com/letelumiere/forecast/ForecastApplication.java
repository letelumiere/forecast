package com.letelumiere.forecast;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

import com.letelumiere.forecast.domain.data.DataController;
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
    CommandLineRunner commandLineRunner(OpenApiService_deprecated service, OpenApiController controller, DataController dataController) {
        return args -> {
            String path = "src\\main\\region.xlsx";
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            String formattedDate = currentDate.format(formatter);

            dataController.postRegionCode(path);
            var codeList = dataController.getRegionCodeList();
 
            var request1 = ShortApiRequest.builder()
                    .pageNo("2")
                    .numOfRows("3")
                    .dataType("JSON")
                    .base_date(formattedDate) //tmcf의 YYYYMMDD는 오늘 날짜로 맞춰서 작성
                    .base_time("0500")
                    .nx("55")
                    .ny("127")
                    .build();

            for(int x=54;x<=56;x++){
                for(int y=127;y<=130;y++){
                    ResponseEntity<ApiShortResponse> response1 = controller.getShortAPI(request1);
                    ResponseEntity<ApiUltShortResponse> response2 = controller.getUltShortAPI(request1);
                }
            }

            codeList.getBody().forEach(code -> {
                if(code.getId()>5) return;

                var request2 = MidApiRequest.builder()
                    .pageNo("1")
                    .numOfRows("10")
                    .dataType("JSON")
                    .regId(code.getCode())
                    .tmFc(formattedDate+"0600")    //tmcf의 YYYYMMDD는 오늘 날짜로 맞춰서 작성
                    .build();

                String str = code.getCode().substring(0, 2);
                if(str.equals("12")) {
                    ResponseEntity<ApiMidSeaResponse> response1 = controller.getMidSeaAPI(request2);
                }else if(str.equals("11")){ //wh...에 뭔가 없으면 진짜로 없어서임 
                    ResponseEntity<ApiMidGrdResponse> response1 = controller.getMidGrdAPI(request2);    
                }
            });

        };
    }

}


