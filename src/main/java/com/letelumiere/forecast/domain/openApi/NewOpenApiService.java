package com.letelumiere.forecast.domain.openApi;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.letelumiere.forecast.domain.data.DataService;
import com.letelumiere.forecast.domain.data.model.RegionCode;
import com.letelumiere.forecast.domain.openApi.model.ApiMidGrdResponse;
import com.letelumiere.forecast.domain.openApi.model.ApiMidSeaResponse;
import com.letelumiere.forecast.domain.openApi.model.ApiShortResponse;
import com.letelumiere.forecast.domain.openApi.model.ApiUltShortResponse;
import com.letelumiere.forecast.domain.openApi.model.MidApiRequest;
import com.letelumiere.forecast.domain.openApi.model.ShortApiRequest;

@Service
public class NewOpenApiService {

    @Autowired
    private DataService dataService;

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

    public ApiShortResponse getShortInfo(ShortApiRequest request){
        String uri = buildShortUri(shtPathURL, request);
        return callApi(uri, ApiShortResponse.class);
    }

    public ApiUltShortResponse getUltShortInfo(ShortApiRequest request){
        String uri = buildShortUri(ultPathURL, request);
        return callApi(uri, ApiUltShortResponse.class);
    }

    public ApiMidGrdResponse getGrdInfo(MidApiRequest request){
        String uri = buildMidUri(midgrdURL, request);
        return callApi(uri, ApiMidGrdResponse.class);
    }

    public ApiMidSeaResponse getSeaInfo(MidApiRequest request){
        String uri = buildMidUri(midseaURL, request);
        return callApi(uri, ApiMidSeaResponse.class);
    }

    public String buildShortUri(String pathUri, ShortApiRequest request){
        return UriComponentsBuilder.fromUriString(pathUri)
            .queryParam("ServiceKey", servicekeyEncode)
            .queryParam("pageNo", request.getPageNo())
            .queryParam("numOfRows", request.getNumOfRows())
            .queryParam("dataType", request.getDataType())
            .queryParam("base_date", request.getBase_date())
            .queryParam("base_time", request.getBase_time())
            .queryParam("nx", request.getNx())
            .queryParam("ny", request.getNy())
            .build()
            .toUriString();
    }

    public String buildMidUri(String pathUri, MidApiRequest request){
        return UriComponentsBuilder.fromUriString(pathUri)
            .queryParam("ServiceKey", servicekeyEncode)
            .queryParam("pageNo", request.getPageNo())
            .queryParam("numOfRows", request.getNumOfRows())
            .queryParam("dataType", request.getDataType())
            .queryParam("regId", request.getRegId())
            .queryParam("tmFc", request.getTmFc())
            .build()
            .toUriString();
    }   


    private <T> T callApi(String uri, Class<T> responseType) {
        HttpEntity<?> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<T> responseEntity = restTemplate.exchange(URI.create(uri), HttpMethod.GET, requestEntity, responseType);
                
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("API 호출 성공. URI: " + uri);

            if (responseType == ApiShortResponse.class) {
                dataService.shortBody((ApiShortResponse) responseEntity.getBody());
            } else if (responseType == ApiUltShortResponse.class){
                dataService.shortUltBody((ApiUltShortResponse) responseEntity.getBody());
            } else if (responseType == ApiMidGrdResponse.class){

            } else if (responseType == ApiMidSeaResponse.class) {
                dataService.midSeaBody((ApiMidSeaResponse) responseEntity.getBody());
            } 

            return responseEntity.getBody();
        } else {
            System.out.println("API 호출 실패. Status Code: " + responseEntity.getStatusCode());
            throw new RestClientException("API 호출 중 오류 발생. Status Code: " + responseEntity.getStatusCode());
        }
    }

    
}
