package com.letelumiere.forecast.domain.openApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class ShortApiResponse { //단기예보, 초단기예보 공용
    private String resultCode;//2	필수	00	결과코드
    private String resultMsg;//50	필수	OK	결과메시지
    private int numOfRows;//4	필수	10	한 페이지 결과 수
    private int pageNo;//4	필수	1	페이지번호
    private int totalCount;//4	필수	3	전체 결과 수
    private String dataType;//4	필수	XML	응답자료형식 (XML/JSON)
    private int baseDate;//8	필수	20210628	‘21년 6월 28일 발표
    private int baseTime;//4	필수	1200	12시00분 발표
    private int nx;//2	필수	55	입력한 예보지점 X 좌표
    private int ny;//2	필수	127	입력한 예보지점 Y 좌표
    private String category;//3	필수	LGT	자료구분코드
    private int fcstDate;//8	필수	20210628	예측일자(YYYYMMDD)
    private int fcstTime;//4	필수	1200	예측시간(HH24MI)
    private int fcstValue;//2	필수	0	예보 값
}
