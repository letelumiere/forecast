package com.letelumiere.forecast.config;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

import org.apache.tomcat.util.digester.DocumentProperties.Charset;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.convert.UriListHttpMessageConverter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

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
}
