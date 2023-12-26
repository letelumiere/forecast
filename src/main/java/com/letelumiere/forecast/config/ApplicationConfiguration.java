package com.letelumiere.forecast.config;

import java.util.Collections;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.annotation.MultipartConfig;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfiguration {

    @Bean
    public HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("text/xml;charset=UTF-8"));
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        
        return new HttpHeaders();
    }


    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        //restTemplate.getMessageConverters().add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
        //restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        //restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
        //restTemplate.getMessageConverters().add(new UriListHttpMessageConverter());
        // XML 메시지 컨버터 관련 부분을 주석 처리 또는 제거
        // restTemplate.getMessageConverters().add(new MappingJackson2XmlHttpMessageConverter());
        // restTemplate.getMessageConverters().add(new SimpleXmlHttpMessageConverter());
        

        return restTemplate;
    }

    @Bean
    public MultipartResolver multipartResolver(){
        return new StandardServletMultipartResolver();
    }

}
