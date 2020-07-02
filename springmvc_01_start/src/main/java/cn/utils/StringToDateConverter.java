package cn.utils;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String,Date> {

    public Date convert(String source) {
        if(source == null){
            throw new RuntimeException("为传入数据");
        }
        try {
            return new SimpleDateFormat("yyyy/MM/dd").parse(source);
        } catch (Exception e) {
            throw new RuntimeException("数据有误");
        }
    }
}
