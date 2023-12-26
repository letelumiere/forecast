package com.letelumiere.forecast.domain.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letelumiere.forecast.domain.data.model.ForecastGrdDTO;
import com.letelumiere.forecast.domain.data.model.ForecastSeaDTO;
import com.letelumiere.forecast.domain.data.model.ForecastShortDTO;
import com.letelumiere.forecast.domain.data.model.ForecastUltShortDTO;
import com.letelumiere.forecast.domain.data.model.RegionCode;
import com.letelumiere.forecast.domain.openApi.model.ApiMidGrdResponse;
import com.letelumiere.forecast.domain.openApi.model.ApiMidSeaResponse;
import com.letelumiere.forecast.domain.openApi.model.ApiShortResponse;
import com.letelumiere.forecast.domain.openApi.model.ApiUltShortResponse;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
@Transactional
public class DataService {

    @Autowired
    ShortRepository shortRepository;

    @Autowired
    UltShortRepository ultShortRepository;

    @Autowired
    LandRepository landRepository;

    @Autowired
    SeaRepository seaRepository;

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
                Cell cellA = row.getCell(1);
                Cell cellB = row.getCell(0);

                var data = RegionCode.builder()
                    .code(cellA.toString())
                    .name(cellB.toString())
                    .build();

                regionRepository.save(data);
            });
            System.out.println("registering List success!");
        }else{
            System.out.println("registering List failed!");
        }
    }

    public List<RegionCode> findAllCodes(){
        return regionRepository.findAll();
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
        for(var item : bodyItem){
            var dto = ForecastGrdDTO.builder()
            .regId(item.getRegId())
            .rnSt3Am(item.getRnSt3Am())
            .rnSt3Pm(item.getRnSt3Pm())
            .rnSt4Am(item.getRnSt4Am())
            .rnSt4Pm(item.getRnSt4Pm())
            .rnSt5Am(item.getRnSt5Am())
            .rnSt5Pm(item.getRnSt5Pm())
            .rnSt6Am(item.getRnSt6Am())
            .rnSt6Pm(item.getRnSt6Pm())
            .rnSt7Am(item.getRnSt7Am())
            .rnSt7Pm(item.getRnSt7Pm())
            .rnSt8(item.getRnSt8())
            .rnSt9(item.getRnSt9())
            .rnSt10(item.getRnSt10())
            .wf3Am(item.getWf3Am())
            .wf3Pm(item.getWf3Pm())
            .wf4Am(item.getWf4Am())
            .wf4Pm(item.getWf4Pm())
            .wf5Am(item.getWf5Am())
            .wf5Pm(item.getWf5Pm())
            .wf6Am(item.getWf6Am())
            .wf6Pm(item.getWf6Pm())
            .wf7Am(item.getWf7Am())
            .wf7Pm(item.getWf7Pm())
            .wf8(item.getWf8())
            .wf9(item.getWf9())
            .wf10(item.getWf10())
            .build();
    
            landRepository.save(dto.toEntity());
        }
    }

    public void midSeaBody(ApiMidSeaResponse param) {   
        var bodyItem = param.getResponse().getBody().getItems().getItem();
        for(var item : bodyItem){
            var dto = ForecastSeaDTO.builder()
                .regId(item.getRegId())
                .wf3Am(item.getWf3Am())
                .wf3Pm(item.getWf3Pm())
                .wf4Am(item.getWf4Am())
                .wf4Pm(item.getWf4Pm())
                .wf5Am(item.getWf5Am())
                .wf5Pm(item.getWf5Pm())
                .wf6Am(item.getWf6Am())
                .wf6Pm(item.getWf6Pm())
                .wf7Am(item.getWf7Am())
                .wf7Pm(item.getWf7Pm())
                .wf8(item.getWf8())
                .wf9(item.getWf9())
                .wf10(item.getWf10())
                .wh3AAm(item.getWh3AAm())
                .wh3APm(item.getWh3APm())
                .wh3BAm(item.getWh3BAm())
                .wh3BPm(item.getWh3BPm())
                .wh4AAm(item.getWh4AAm())
                .wh4APm(item.getWh4APm())
                .wh4BAm(item.getWh4BAm())
                .wh4BPm(item.getWh4BPm())
                .wh5AAm(item.getWh5AAm())
                .wh5APm(item.getWh5APm())
                .wh5BAm(item.getWh5BAm())
                .wh5BPm(item.getWh5BPm())
                .wh6AAm(item.getWh6AAm())
                .wh6APm(item.getWh6APm())
                .wh6BAm(item.getWh6BAm())
                .wh6BPm(item.getWh6BPm())
                .wh7AAm(item.getWh7AAm())
                .wh7APm(item.getWh7APm())
                .wh7BAm(item.getWh7BAm())
                .wh7BPm(item.getWh7BPm())
                .wh8A(item.getWh8A() )
                .wh8B(item.getWh8B())
                .wh9A(item.getWh9A())
                .wh9B(item.getWh9B())
                .wh10A(item.getWh10A())
                .wh10B(item.getWh10B())
                .build();
            seaRepository.save(dto.toEntity());
        }
    }
}
