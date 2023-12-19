package com.letelumiere.forecast.domain.openApi.model;

import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiVerRequest {
    private String ServiceKey;
    private int pageNo; //페이지번호
    private int numOfRows;	
    private String dataType;	//XML, JSOn
    private String ftype; // ODAM    파일구분 -ODAM: 동네예보실황 -VSRT: 동네예보초단기 -SHRT: 동네예보단기
    private String basedatetime; //	    202106280800
}
