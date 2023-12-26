package com.letelumiere.forecast.domain.openApi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letelumiere.forecast.domain.data.DataService;
import com.letelumiere.forecast.domain.data.model.RegionCode;
import com.letelumiere.forecast.domain.openApi.model.ApiMidGrdResponse;
import com.letelumiere.forecast.domain.openApi.model.ApiMidSeaResponse;
import com.letelumiere.forecast.domain.openApi.model.ApiShortResponse;
import com.letelumiere.forecast.domain.openApi.model.ApiUltShortResponse;
import com.letelumiere.forecast.domain.openApi.model.MidApiRequest;
import com.letelumiere.forecast.domain.openApi.model.ShortApiRequest;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OpenApiController {
    
    @Autowired
    private final NewOpenApiService openApiService;

    @GetMapping("/shortAPI") 
    public ResponseEntity<ApiShortResponse> getShortAPI(@RequestBody ShortApiRequest request){
        return ResponseEntity.ok(openApiService.getShortInfo(request));
    }

    @GetMapping("/ultshortAPI") 
    public ResponseEntity<ApiUltShortResponse> getUltShortAPI(@RequestBody ShortApiRequest request){
        return ResponseEntity.ok(openApiService.getUltShortInfo(request));
    }

    @GetMapping("/midSeaAPI")
    public ResponseEntity<ApiMidSeaResponse> getMidSeaAPI(@RequestBody MidApiRequest request){        
        return ResponseEntity.ok(openApiService.getSeaInfo(request));
    }

    @GetMapping("/midGrdAPI")
    public ResponseEntity<ApiMidGrdResponse> getMidGrdAPI(@RequestBody MidApiRequest request){        
        return ResponseEntity.ok(openApiService.getGrdInfo(request));
    }
}
