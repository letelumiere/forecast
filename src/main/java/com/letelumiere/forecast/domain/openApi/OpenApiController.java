package com.letelumiere.forecast.domain.openApi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letelumiere.forecast.domain.openApi.model.ApiMidGrdResponse;
import com.letelumiere.forecast.domain.openApi.model.ApiMidSeaResponse;
import com.letelumiere.forecast.domain.openApi.model.ApiShortResponse;
import com.letelumiere.forecast.domain.openApi.model.MidApiRequest;
import com.letelumiere.forecast.domain.openApi.model.ShortApiReqeust;


import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OpenApiController {
    
    @Autowired
    private final OpenApiService openApiService;
    
    @GetMapping("/shortAPI") 
    public ResponseEntity<ApiShortResponse> getShortAPI(@RequestBody ShortApiReqeust request){
        return ResponseEntity.ok(openApiService.getShortInfo(request));
    }

    @GetMapping("/ultshortAPI") 
    public ResponseEntity<ApiShortResponse> getUltShortAPI(@RequestBody ShortApiReqeust request){
        return ResponseEntity.ok(openApiService.getUltShortInfo(request));
    }


    @GetMapping("/midSeaAPI")
    public ResponseEntity<ApiMidSeaResponse> getMidSeaAPI(@RequestBody MidApiRequest request){        
        return ResponseEntity.ok(openApiService.getMidSeaInfo(request));
    }

    @GetMapping("/midGrdAPI")
    public ResponseEntity<ApiMidGrdResponse> getMidGrdAPI(@RequestBody MidApiRequest request){        
        return ResponseEntity.ok(openApiService.getMidgrdInfo(request));
    }
}
