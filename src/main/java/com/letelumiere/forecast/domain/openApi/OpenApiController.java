package com.letelumiere.forecast.domain.openApi;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letelumiere.forecast.domain.openApi.model.ShortApiReqeust;
import com.letelumiere.forecast.domain.openApi.model.ShortApiResponse;

import jakarta.persistence.Converter;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OpenApiController {
    private final OpenApiService openApiService;
    
    @GetMapping("/shortAPI") 
    public ResponseEntity<ShortApiResponse> getShortAPI(@RequestBody ShortApiReqeust request){
        return ResponseEntity.ok(openApiService.getShortInfo(request));
    }

}
