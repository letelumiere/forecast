package com.letelumiere.forecast.domain.openApi;

import java.net.URI;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.letelumiere.forecast.domain.data.model.ForecastGrd;
import com.letelumiere.forecast.domain.data.model.ForecastShort;
import com.letelumiere.forecast.domain.openApi.model.ApiMidGrdResponse;
import com.letelumiere.forecast.domain.openApi.model.ApiMidSeaResponse;
import com.letelumiere.forecast.domain.openApi.model.ApiShortResponse;
import com.letelumiere.forecast.domain.openApi.model.MidApiRequest;
import com.letelumiere.forecast.domain.openApi.model.ShortApiReqeust;
import com.letelumiere.forecast.domain.openApi.model.ApiMidGrdResponse.Response.Body.Items.Item;


@Service
public class OpenApiService {

    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private HttpHeaders httpHeaders;
    
    @Value("${servicekey.encode}")
    private String servicekeyEncode;

    @Value("${servicekey.decode}")
    private String servicekeyDecode;

    @Value("${url.base}"+"${url.short.path}")
    private String shtPathURL;

    @Value("${url.base}"+"${url.short.ultpath}")
    private String ultPathURL;
    
    @Value("${url.base}"+"${url.mid.grd}")
    private String midgrdURL;

    @Value("${url.base}"+"${url.mid.sea}")
    private String midseaURL;

    //초단기 LGT, 단기는 TMP
    public ApiShortResponse getUltShortInfo(ShortApiReqeust request)  {
        // UriComponentsBuilder를 사용하여 URI 생성
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(ultPathURL)
            .queryParam("ServiceKey", servicekeyEncode)
            .queryParam("pageNo", request.getPageNo())
            .queryParam("numOfRows", request.getNumOfRows())
            .queryParam("dataType", request.getDataType())
            .queryParam("base_date", request.getBase_date())
            .queryParam("base_time", request.getBase_time())
            .queryParam("nx", request.getNx())
            .queryParam("ny", request.getNy());
        
        String uri = builder.build().toUriString();
        
        HttpEntity<?> requestEntity = new HttpEntity<>(httpHeaders);
        
        ResponseEntity<ApiShortResponse> responseEntity = 
            restTemplate.exchange(URI.create(uri), HttpMethod.GET, requestEntity,ApiShortResponse.class);

            
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("초단기예보 parameter= " + uri);

            return responseEntity.getBody();
        } else {
            System.out.println("No response or error occurred. Status Code: " + responseEntity.getStatusCode());
            throw new RestClientException("Error occurred during API call. Status Code: " + responseEntity.getStatusCode());
        }
    }

    public ApiShortResponse getShortInfo(ShortApiReqeust request)  {
        // UriComponentsBuilder를 사용하여 URI 생성
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(shtPathURL)
            .queryParam("ServiceKey", servicekeyEncode)
            .queryParam("pageNo", request.getPageNo())
            .queryParam("numOfRows", request.getNumOfRows())
            .queryParam("dataType", request.getDataType())
            .queryParam("base_date", request.getBase_date())
            .queryParam("base_time", request.getBase_time())
            .queryParam("nx", request.getNx())
            .queryParam("ny", request.getNy());
        
        String uri = builder.build().toUriString();
        
        HttpEntity<?> requestEntity = new HttpEntity<>(httpHeaders);
        
        ResponseEntity<ApiShortResponse> responseEntity = 
            restTemplate.exchange(URI.create(uri), HttpMethod.GET, requestEntity,ApiShortResponse.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("단기예보 parameter= " + uri);

            body(responseEntity.getBody());
            return responseEntity.getBody();
        } else {
            System.out.println("No response or error occurred. Status Code: " + responseEntity.getStatusCode());
            throw new RestClientException("Error occurred during API call. Status Code: " + responseEntity.getStatusCode());
        }
    }

    public ApiMidSeaResponse getMidSeaInfo(MidApiRequest request) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(midseaURL)
            .queryParam("ServiceKey", servicekeyEncode)
            .queryParam("pageNo", request.getPageNo())
            .queryParam("numOfRows", request.getNumOfRows())
            .queryParam("dataType", request.getDataType())
            .queryParam("regId", request.getRegId())
            .queryParam("tmFc", request.getTmFc());
        
        String uri = builder.build().toUriString();

        HttpEntity<?> requestEntity = new HttpEntity<>(httpHeaders);
        
        ResponseEntity<ApiMidSeaResponse> responseEntity = 
            restTemplate.exchange(URI.create(uri), HttpMethod.GET, requestEntity,ApiMidSeaResponse.class);


        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("중기해상예보 parameter= " + uri);

            return responseEntity.getBody();
        } else {
            System.out.println("No response or error occurred. Status Code: " + responseEntity.getStatusCode());
            throw new RestClientException("Error occurred during API call. Status Code: " + responseEntity.getStatusCode());
        }
    }

        public ApiMidGrdResponse getMidgrdInfo(MidApiRequest request) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(midgrdURL)
            .queryParam("ServiceKey", servicekeyEncode)
            .queryParam("pageNo", request.getPageNo())
            .queryParam("numOfRows", request.getNumOfRows())
            .queryParam("dataType", request.getDataType())
            .queryParam("regId", request.getRegId())
            .queryParam("tmFc", request.getTmFc());
        
        String uri = builder.build().toUriString();

        HttpEntity<?> requestEntity = new HttpEntity<>(httpHeaders);
        
        ResponseEntity<ApiMidGrdResponse> responseEntity = 
            restTemplate.exchange(URI.create(uri), HttpMethod.GET, requestEntity,ApiMidGrdResponse.class);


        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("중기육상예보 parameter= " + uri);
            body(responseEntity.getBody());
            return responseEntity.getBody();
        } else {
            System.out.println("No response or error occurred. Status Code: " + responseEntity.getStatusCode());
            throw new RestClientException("Error occurred during API call. Status Code: " + responseEntity.getStatusCode());
        }
    }

    public void body(ApiMidGrdResponse bodyResponse){   
        var items = bodyResponse.getResponse().getBody().getItems().getItem();
        for(Item grdItem : items){
            System.out.println(grdItem.getClass());
        }

    }

    public void body(ApiShortResponse bodyResponse){   
        var bodyItem = bodyResponse.getResponse().getBody().getItems().getItem();
        for(var shortItem : bodyItem){
            //System.out.println("shortItem = " + shortItem.getBaseDate());
            //System.out.println("shortItem = " + shortItem.getCategory());
            var dto = ForecastShort.builder()
                .baseDate(shortItem.getBaseDate())
                .baseTime(shortItem.getBaseTime())
                .nx(shortItem.getNx())
                .ny(shortItem.getNy())
                .category(shortItem.getCategory())
                .build();
            System.out.println("dto = " + dto.getBaseDate() + " " + dto.getBaseTime() + " " + dto.getNx() + "," + dto.getNy() + " " + dto.getCategory());
        }

    }
}

