package com.letelumiere.forecast.domain.data;

import com.letelumiere.forecast.domain.data.model.ForecastShort;
import com.letelumiere.forecast.domain.openApi.model.ApiMidGrdResponse;
import com.letelumiere.forecast.domain.openApi.model.ApiMidSeaResponse;
import com.letelumiere.forecast.domain.openApi.model.ApiShortResponse;
import com.letelumiere.forecast.domain.openApi.model.ApiUltShortResponse;

public class DataService {

    public void shortBody(ApiShortResponse param) {   
        var bodyItem = param.getResponse().getBody().getItems().getItem();
        for(var shortItem : bodyItem){
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

    public void shortUltBody(ApiUltShortResponse param){
        var bodyItem = param.getResponse().getBody().getItems().getItem();

    }

    public void midGrdBody(ApiMidGrdResponse param){
        var bodyItem = param.getResponse().getBody().getItems().getItem();
        
    }

    public void midSeaBody(ApiMidSeaResponse param) {   
        var bodyItem = param.getResponse().getBody().getItems().getItem();

    }
}
