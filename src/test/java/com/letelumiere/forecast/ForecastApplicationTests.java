package com.letelumiere.forecast;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.web.client.RestTemplate;

import com.letelumiere.forecast.domain.data.DataController;
import com.letelumiere.forecast.domain.data.model.RegionCode;
import com.letelumiere.forecast.domain.openApi.OpenApiController;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ForecastApplicationTests {

    @Autowired
    OpenApiController apiController;

    @Autowired
    DataController dataController;

    @MockBean
    private MockRestServiceServer mockRestServiceServer;

	@SpyBean
	private RestTemplate restTemplate;


    void testExternalApiCall() {
        // 외부 API 호출 대신 Mock 응답 설정
//        mockRestServiceServer
//                .expect(MockRestRequestMatchers.requestTo("http"))
//                .andRespond(MockRestResponseCreators.withStatus(HttpStatus.OK)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .body("{ \"message\": \"Hello\" }"));

/*         // 외부 API 호출
        ResponseEntity<ShortApiResponse> responseEntity = apiController.getShortAPI(getTestApiRequest());

        // 응답이 null이 아닌지 확인
        assertNotNull(responseEntity);

        // ResponseEntity의 body를 확인
        ShortApiResponse shortApiResponse = responseEntity.getBody();
        assertNotNull(shortApiResponse);

        // 응답 결과 출력
        System.out.println("External API Response: " + shortApiResponse);
        
    }

    private ShortApiReqeust getTestApiRequest() {
        return ShortApiReqeust.builder()
                .serviceKey("LtU1iAgzFsSLt%2B%2BlIFdaFpZuMv%2BXPFR3tHw9XbFDBTOdm%2BztvmN1%2BIgqxmk6F5V%2FJggpSEWj43t3iEUW99RzYQ%3D%3D")
                .pageNo("1")
                .numOfRows("1")
                .dataType("JSON")
                .base_date("20231219")
                .base_time("0500")
                .nx("55")
                .ny("127")
                .build();
    }
    */
    }
}
