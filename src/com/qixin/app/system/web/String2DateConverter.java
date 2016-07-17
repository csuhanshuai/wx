package com.qixin.app.system.web;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import com.qixin.app.zjminweb.common.CommonTool;

public class String2DateConverter implements Converter<String, Date>
{

    @Override
    public Date convert(String arg0)
    {
        return CommonTool.conversionDate(arg0, "yyyy-MM-dd HH:mm:ss");
    }

}
