package com.letelumiere.forecast.config;

import org.apache.tomcat.util.digester.DocumentProperties.Charset;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfiguration {

    @Bean
    public HttpHeaders getHeaders(){
        return new HttpHeaders();
    }

    
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    
    String baseUrl = "http://apis.data.go.kr/1360000";

    String villageServiceUrl = "/VilageFcstInfoService_2.0";
    String MidFcstInfoService = "/MidFcstInfoService";

    String getVilageFcst = "/getVilageFcst"; 
    String getUltraSrtFcst = "/getUltraSrtFcst";

    String getMidFcstUrl = "/getMidFcst";
    String getMidSeaFcstUrl = "/getMidSeaFcst";


}
