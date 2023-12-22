package com.letelumiere.forecast.domain.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letelumiere.forecast.domain.data.model.ForecastShort;
import com.letelumiere.forecast.domain.data.model.ForecastShortDTO;
import com.letelumiere.forecast.domain.data.model.ForecastUltShortDTO;
import com.letelumiere.forecast.domain.openApi.model.ApiMidGrdResponse;
import com.letelumiere.forecast.domain.openApi.model.ApiMidSeaResponse;
import com.letelumiere.forecast.domain.openApi.model.ApiShortResponse;
import com.letelumiere.forecast.domain.openApi.model.ApiUltShortResponse;

@Service
public class DataService {

    @Autowired
    ShortRepository shortRepository;

    @Autowired
    UltShortRepository ultShortRepository;

    public void shortBody(ApiShortResponse param) {   
        var bodyItem = param.getResponse().getBody().getItems().getItem();
        for(var shortItem : bodyItem){
            var dto = ForecastShortDTO.builder()
                .baseDate(shortItem.getBaseDate())
                .baseTime(shortItem.getBaseTime())
                .nx(shortItem.getNx())
                .ny(shortItem.getNy())
                .category(shortItem.getCategory())
                .fcstDate(shortItem.getFcstDate())
                .fcstTime(shortItem.getFcstTime())
                .fcstValue(shortItem.getFcstValue())
                .build();

            shortRepository.save(dto.toEntity());
        }
    }

    public void shortUltBody(ApiUltShortResponse param){
        var bodyItem = param.getResponse().getBody().getItems().getItem();
        for(var shortItem : bodyItem){
            var dto = ForecastUltShortDTO.builder()
                .baseDate(shortItem.getBaseDate())
                .baseTime(shortItem.getBaseTime())
                .nx(shortItem.getNx())
                .ny(shortItem.getNy())
                .category(shortItem.getCategory())
                .fcstDate(shortItem.getFcstDate())
                .fcstTime(shortItem.getFcstTime())
                .fcstValue(shortItem.getFcstValue())
                .build();

            ultShortRepository.save(dto.toEntity());
        }
    }

    public void midGrdBody(ApiMidGrdResponse param){
        var bodyItem = param.getResponse().getBody().getItems().getItem();
        
    }

    public void midSeaBody(ApiMidSeaResponse param) {   
        var bodyItem = param.getResponse().getBody().getItems().getItem();

    }
}
