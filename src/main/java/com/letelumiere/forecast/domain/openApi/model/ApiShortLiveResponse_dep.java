package com.letelumiere.forecast.domain.openApi.model;


//초단기 실황조회
public class ApiShortLiveResponse_dep {
    private String resultCode; //결과코드		2	필수	00	결과코드
    private String resultMsg; //결과메시지		50	필수	OK	결과메시지
    private int numOfRows; //한 페이지 결과 수		4	필수	10	한 페이지 결과 수
    private int pageNo; //페이지 번호		4	필수	1	페이지번호
    private int totalCount; //전체 결과 수		4	필수	3	전체 결과 수
    private String dataType; //데이터 타입		4	필수	XML	응답자료형식 (XML/JSON)
    private int baseDate; //발표일자		8	필수	20210628	‘21년 6월 28일 발표
    private int baseTime; //발표시각		6	필수	0600	06시 발표(매 정시)
    private int nx; //예보지점 X 좌표	nx	2	필수	55	입력한 예보지점 X 좌표
    private int ny; //예보지점 Y 좌표	ny	2	필수	127	입력한 예보지점 Y 좌표
    private String category; //자료구분코드		3	필수	RN1	자료구분코드
    private String obsrValue; //실황 값		2	필수	0	RN1, T1H, UUU, VVV, WSD 실수로 제공
}

