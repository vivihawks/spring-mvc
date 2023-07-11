package com.baeldung.spring.converter;

import org.springframework.core.convert.converter.Converter;

import com.baeldung.model.Modes;

public class StringToEnumConverter implements Converter<String, Modes> {

    @Override
    public Modes convert(String from) {
        return Modes.valueOf(from);
    }
}