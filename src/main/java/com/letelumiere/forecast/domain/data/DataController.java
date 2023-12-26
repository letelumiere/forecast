package com.letelumiere.forecast.domain.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.Region;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.letelumiere.forecast.domain.data.model.RegionCode;
import com.letelumiere.forecast.domain.openApi.model.ApiShortResponse;
import com.letelumiere.forecast.domain.openApi.model.ShortApiRequest;


@Controller
public class DataController {

    @Autowired
    DataService dataService;


    @PostMapping("/registerRegion") 
    public void postRegionCode(@RequestBody String request) throws IOException{ //src\\main\\region.xlsx
        dataService.xslxToList(request);
    }

}



/*
 * public static List<FoodInfo> excelDataToListOfObjets_withApachePOI(String fileLocation)
  throws IOException {
    FileInputStream file = new FileInputStream(new File(fileLocation));
    Workbook workbook = new XSSFWorkbook(file);
    Sheet sheet = workbook.getSheetAt(0);
    List<FoodInfo> foodData = new ArrayList<FoodInfo>();
    DataFormatter dataFormatter = new DataFormatter();
    for (int n = 1; n < sheet.getPhysicalNumberOfRows(); n++) {
        Row row = sheet.getRow(n);
        FoodInfo foodInfo = new FoodInfo();
        int i = row.getFirstCellNum();

        foodInfo.setCategory(dataFormatter.formatCellValue(row.getCell(i)));
        foodInfo.setName(dataFormatter.formatCellValue(row.getCell(++i)));
        foodInfo.setMeasure(dataFormatter.formatCellValue(row.getCell(++i)));
        foodInfo.setCalories(row.getCell(++i).getNumericCellValue());
       
        foodData.add(foodInfo);
    }
    return foodData;
}
 * 
 * 
 */