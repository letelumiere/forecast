package com.letelumiere.forecast;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import com.letelumiere.forecast.domain.openApi.OpenApiController;
import com.letelumiere.forecast.domain.openApi.OpenApiService;
import com.letelumiere.forecast.domain.openApi.model.ShortApiReqeust;

@SpringBootTest
class ForecastApplicationTests {

	@Autowired OpenApiController apiController;

	@DisplayName("테스트 1")
	@Test
	void contextLoads() {
	
		var apiRequest = ShortApiReqeust.builder()
			.ServiceKey("LtU1iAgzFsSLt%2B%2BlIFdaFpZuMv%2BXPFR3tHw9XbFDBTOdm%2BztvmN1%2BIgqxmk6F5V%2FJggpSEWj43t3iEUW99RzYQ%3D%3D")
			.pageNo(1)
			.numOfRows(1)
			.dataType("JSON")
			.base_date(20231219)
			.base_time(0630)
			.nx(55)
			.ny(127)
			.build();
		
			apiController.getShortAPI(apiRequest);
	}
}
