package com.letelumiere.forecast.domain.openApi.model;

public class ApiMidGrdResponse {
    private String resultCode;//    결과코드		2	필수	00	결과코드
    private String resultMsg;//    결과메시지		50	필수	OK	결과메시지
    private String numOfRows;//    한 페이지 결과 수		4	필수	10	한 페이지 결과 수
    private String pageNo;//    페이지 번호		4	필수	1	3
    private String totalCount;//4	전체 결과 수 필수	3	전체 결과 수
    private String dataType;//4	데이터 타입필수	XML	응답자료형식 (XML/JSON)
    private String regid;//8	예보구역코드 필수	11D20000	예보구역코드
    private int rnSt3Am;//3	3일 후 오전 강수 확률	 필수	40	3일 후 오전 강수 확률
    private int rnSt3Pm;//3	3일 후 오후 강수 확률	 필수	40	3일 후 오후 강수 확률
    private int rnSt4Am;//3	4일 후 오전 강수 확률	 필수	30	4일 후 오전 강수 확률
    private int rnSt4Pm;//3	4일 후 오후 강수 확률	 필수	30	4일 후 오후 강수 확률
    private int rnSt5Am;//3	5일 후 오전 강수 확률	필수	30	5일 후 오전 강수 확률
    private int rnSt5Pm;//3	5일 후 오후 강수 확률	 필수	30	5일 후 오후 강수 확률
    private int rnSt6Am;//3	6일 후 오전 강수 확률	 필수	30	6일 후 오전 강수 확률
    private int rnSt6Pm;//3	6일 후 오후 강수 확률	필수	30	6일 후 오후 강수 확률
    private int rnSt7Am;//3	7일 후 오전 강수 확률	필수	30	7일 후 오전 강수 확률
    private int rnSt7Pm;//3	7일 후 오후 강수 확률 필수	30	7일 후 오후 강수 확률
    private int rnSt8;//3	8일 후 강수 확률	 필수	30	8일 후 강수 확률
    private int rnSt9;//3	9일 후 강수 확률	 필수	30	9일 후 강수 확률
    private int rnSt10;//10일 후 강수 확률	 3	필수	30	10일 후 강수 확률
    private String wf3Am;//4	3일 후 오전 날씨예보	 필수	구름많음	3일 후 오전 날씨예보
    private String wf3Pm;//4	3일 후 오후 날씨예보	필수	구름많음	3일 후 오후 날씨예보
    private String wf4Am;//4	4일 후 오전 날씨예보	 필수	흐리고 비	4일 후 오전 날씨예보
    private String wf4Pm;//4	4일 후 오전 날씨예보	 필수	구름많음	4일 후 오전 날씨예보
    private String wf5Am;//4	5일 후 오전 날씨예보	필수	흐리고 비	5일 후 오전 날씨예보
    private String wf5Pm;//4	5일 후 오후 날씨예보	필수	구름많음	5일 후 오후 날씨예보
    private String wf6Am;//4	6일 후 오전 날씨예보	필수	흐리고 비	6일 후 오전 날씨예보
    private String wf6Pm;//5	6일 후 오후 날씨예보	필수	구름많고 비	6일 후 오후 날씨예보
    private String wf7Am;//4	7일 후 오전 날씨예보	필수	구름많음	7일 후 오전 날씨예보
    private String wf7Pm;//4	7일 후 오후 날씨예보	필수	구름많음	7일 후 오후 날씨예보
    private String wf8;//4	8일 후 날씨예보	필수	구름많음	8일 후 날씨예보
    private String wf9;//4	9일 후 날씨예보	필수	흐리고 비	9일 후 날씨예보
    private String wf10;//4	10일 후 날씨예보	필수	구름많음	10일 후 날씨예보
}
