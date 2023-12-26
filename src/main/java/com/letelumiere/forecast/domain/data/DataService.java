package com.letelumiere.forecast.domain.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.letelumiere.forecast.domain.data.model.ForecastShort;
import com.letelumiere.forecast.domain.data.model.ForecastShortDTO;
import com.letelumiere.forecast.domain.data.model.ForecastUltShortDTO;
import com.letelumiere.forecast.domain.data.model.RegionCode;
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

    @Autowired
    RegionRepository regionRepository;


    public void xslxToList(String param) throws IOException{ //fileLocation = src\\main\\region.xlsx
        FileInputStream file = new FileInputStream(new File(param));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        List<RegionCode> codeList = new ArrayList<>();
        DataFormatter dataFormatter = new DataFormatter();

        if(sheet!=null){
            sheet.forEach(row -> { //Row row = sheet.getRow();
                Cell cellA = row.getCell(0);
                Cell cellB = row.getCell(1);

                var data = RegionCode.builder()
                    .code(cellA.toString())
                    .name(cellB.toString())
                    .build();

                regionRepository.save(data);
            });
        }else{
            System.out.println("registering List failed!");
        }

    }


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
