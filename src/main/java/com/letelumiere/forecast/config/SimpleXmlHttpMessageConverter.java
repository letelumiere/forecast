package com.letelumiere.forecast.config;

import java.io.IOException;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

// 추가: XML 요청 및 응답을 처리하는 컨버터

    public class SimpleXmlHttpMessageConverter extends AbstractHttpMessageConverter<Object> {

        public SimpleXmlHttpMessageConverter() {
            super(new MediaType("application", "xml"));
        }

        @Override
        protected boolean supports(Class<?> clazz) {
            return true;
        }

        @Override
        protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
            // XML을 읽어와서 객체로 변환하는 로직 추가
            // 이 부분은 사용하는 XML 매핑 라이브러리에 따라 구현이 달라집니다.
            return null;
        }

        @Override
        protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
            // 객체를 XML로 변환하여 출력하는 로직 추가
            // 이 부분은 사용하는 XML 매핑 라이브러리에 따라 구현이 달라집니다.
        }
    }

    