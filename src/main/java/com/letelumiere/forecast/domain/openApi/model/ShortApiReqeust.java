package com.letelumiere.forecast.domain.openApi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor  //단기 초단기 공용
public class ShortApiReqeust {
    private String serviceKey; // 공공데이터포털에서 받은 인증키
    private int pageNo; //페이지번호
    private int numOfRows; //한 페이지 결과 수
    private String dataType; // 요청자료형식(XML/JSON) Default: XML
    private int base_date; //20210628 ‘21년 6월 28일 발표
    private int base_time; // 0600 06시 발표(정시단위)
    private int nx; //55 예보지점의 X 좌표값
    private int ny;	// 127 예보지점의 Y 좌표값
}

