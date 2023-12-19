package com.letelumiere.forecast.domain.openApi.model;

public class ApiMidSeaResponse {
    private String resultCode;//2	필수	00	결과코드
    private String resultMsg;//50	필수	OK	결과메시지
    private String numOfRows;//4	필수	10	한 페이지 결과 수
    private String pageNo;//4	필수	1	3
    private String totalCount;//4	필수	3	전체 결과 수
    private String dataType;//4	필수	XML	응답자료형식 (XML/JSON)
    private String regId;//8	필수	12A10000	입력한 예보구역코드
    private String wf3Am;//4	필수	구름많음	3일후 오전날씨예보
    private String wf3Pm;//4	필수	구름많음	3일후 오후날씨예보
    private String wf4Am;//4	필수	구름많음	4일후 오전날씨예보
    private String wf4Pm;//4	필수	구름많음	4일후 오후날씨예보
    private String wf5Am;//5	필수	구름많고비	5일후 오전날씨예보
    private String wf5Pm;//5	필수	구름많고비	5일후 오후날씨예보
    private String wf6Am;//5	필수	구름많고비	6일후 오전날씨예보
    private String wf6Pm;//4	옵션	구름많음	6일후 오후날씨예보
    private String wf7Am;//4	옵션	구름많음	7일후 오전날씨예보
    private String wf7Pm;//4	옵션	구름많음	7일후 오후날씨예보
    private String wf8;//4	옵션	구름많음	8일후 날씨예보
    private String wf9;//4	옵션	구름많음	9일후 날씨예보
    private String wf10;//4	옵션	구름많음	10일후 날씨예보
    private int wh3AAm;//1	필수	1	3일후 오전 최저 예상파고(m)
    private int wh3APm;//1	필수	3	3일후 오후 최저 예상파고(m)
    private int wh3BAm;//1	필수	1	3일후 오전 최고 예상파고(m)
    private int wh3BPm;//1	필수	3	3일후 오후 최고
    private int wh4AAm;//1	필수	1	4일후 오전 최저
    private int wh4APm;//1	필수	3	4일후 오후 최저
    private int wh4BAm;//1	필수	1	4일후 오전 최고
    private int wh4BPm;//1	필수	3	4일후 오후 최고
    private int wh5AAm;//1	필수	1	5일후 오전 최저
    private int wh5APm;//1	필수	3	5일후 오후 최저
    private int wh5BAm;//1	필수	1	5일후 오전 최고
    private int wh5BPm;//1	필수	3	5일후 오후 최고
    private int wh6AAm;//1	필수	1	6일후 오전 최저
    private int wh6APm;//1	필수	3	6일후 오후 최저
    private int wh6BAm;//1	필수	1	6일후 오전 최고
    private int wh6BPm;//1	필수	3	6일후 오후 최고
    private int wh7AAm;//1	필수	1	7일후 오전 최저
    private int wh7APm;//1	필수	3	7일후 오후 최저
    private int wh7BAm;//1	필수	1	7일후 오전 최고
    private int wh7BPm;//1	필수	3	7일후 오후 최고
    private int wh8A;//1	필수	1	8일후 최저예상파고(m)
    private int wh8B;//1	필수	3	8일후 최고 예상파고(m)
    private int wh9A;//1	필수	1	9일후 최저예상파고(m)
    private int wh9B;//1	필수	3	9일후 최고 예상파고(m)
    private int wh10A;//1	필수	1	10일후 최저예상파고(m)
    private int wh10B;//1	필수	3	10일후 최고 예상파고(m)
}