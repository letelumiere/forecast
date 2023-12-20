package com.letelumiere.forecast.domain.openApi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MidApiRequest {
    private String serviceKey; //공공데이터포털에서 받은 인증키
    private String pageNo; //페이지번호
    private String numOfRows; //한 페이지 결과 수
    private String dataType; //요청자료형식(XML/JSON)Default: XML
    private String regId; //11B0000 서울, 인천, 경기도 11D10000 등 (활용가이드 하단 참고자료 참조)
    private String tmFc; //-일 2회(06:00,18:00)회 생성 되며 발표시각을 입력 YYYYMMDD0600(1800)-최근 24시간 자료만 제공
}
