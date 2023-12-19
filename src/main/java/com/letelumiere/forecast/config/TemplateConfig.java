package com.letelumiere.forecast.config;

import org.apache.tomcat.util.digester.DocumentProperties.Charset;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class TemplateConfig { 
    
}
    
    /*


    public class TemplateConfig {
        @Bean
        public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
            return restTemplateBuilder
                    .requestFactory(() -> new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()))
                    .setConnectTimeout(Duration.ofMillis(5000)) // connection-timeout
                    .setReadTimeout(Duration.ofMillis(5000)) // read-timeout
                    .additionalMessageConverters(new StringHttpMessageConverter(Charset.forName("UTF-8")))
                    .build();
        }
    }    
    
    public class TestServiceImpl {
        @Service("FifaonService")
        implements FifaonService {
        private static final String AUTHORIZATION = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NvdW50X2lkIjoiMTMyNjIwNzg1OCIsImF1dGhfaWQiOiIyIiwidG9rZW5fdHlwZSI6IkFjY2Vzc1Rva2VuIiwic2VydmljZV9pZCI6IjQzMDAxMTQ4MSIsIlgtQXBwLVJhdGUtTGltaXQiOiI1MDA6MTAiLCJuYmYiOjE2MDg5NzU0MTgsImV4cCI6MTYyNDUyNzQxOCwiaWF0IjoxNjA4OTc1NDE4fQ.xBWhSNzSc_nkrXTJdTYSmsk8enfADOvoppRhfaCtYQw";
        private RestTemplate restTemplate;
        private JsonParser jParser;
        
        @Autowired
        public void FifaonService(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }
        
        @Override
        public Users SearchUserByNickname(String nickname) {
            String base_url = "https://api.nexon.co.kr/fifaonline4/v1.0/users?";
            
            URI uriBuilder = UriComponentsBuilder.fromHttpUrl(base_url)
                    .queryParam("nickname", nickname)
                    .build("usersInfo");
            
            HttpHeaders httpheaders = new HttpHeaders();
            httpheaders.add("Authorization", AUTHORIZATION);
            httpheaders.add("Content-Type","application/json; charset=UTF-8");
            
            RequestEntity<Void> requestEntity = RequestEntity.get(uriBuilder).headers(httpheaders).build();
            ResponseEntity<Users> response = restTemplate.exchange(uriBuilder, HttpMethod.GET, requestEntity, Users.class);
            
            Users users = response.getBody();
            
            return users;
        }
    
        */
