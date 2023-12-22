package com.letelumiere.forecast.domain.openApi;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DataType {
    XML("XML", "XML"),
    JSON("JSON", "JSON");

    private final String code;
    private final String description;
}
