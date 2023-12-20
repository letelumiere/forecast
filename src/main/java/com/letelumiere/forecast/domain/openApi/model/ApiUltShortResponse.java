package com.letelumiere.forecast.domain.openApi.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiUltShortResponse {

    @JsonProperty("response")
    private Response response;

    @Data
    public static class Response {

        @JsonProperty("header")
        private Header header;

        @JsonProperty("body")
        private Body body;

        @Data
        public static class Header {

            @JsonProperty("resultCode")
            private String resultCode;

            @JsonProperty("resultMsg")
            private String resultMsg;
        }

        @Data
        public static class Body {

            @JsonProperty("dataType")
            private String dataType;

            @JsonProperty("items")
            private Items items;

            @JsonProperty("pageNo")
            private int pageNo;

            @JsonProperty("numOfRows")
            private int numOfRows;

            @JsonProperty("totalCount")
            private int totalCount;

            @Data
            public static class Items {

                @JsonProperty("item")
                private List<Item> item;

                @Data
                public static class Item {

                    @JsonProperty("baseDate")
                    private String baseDate;

                    @JsonProperty("baseTime")
                    private String baseTime;

                    @JsonProperty("category")
                    private String category;

                    @JsonProperty("fcstDate")
                    private String fcstDate;

                    @JsonProperty("fcstTime")
                    private String fcstTime;

                    @JsonProperty("fcstValue")
                    private String fcstValue;

                    @JsonProperty("nx")
                    private int nx;

                    @JsonProperty("ny")
                    private int ny;
                }
            }
        }
    }
}