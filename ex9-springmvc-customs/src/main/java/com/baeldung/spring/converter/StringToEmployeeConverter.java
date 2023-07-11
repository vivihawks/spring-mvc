package com.baeldung.spring.converter;

import org.springframework.core.convert.converter.Converter;

import com.baeldung.model.Employee;

public class StringToEmployeeConverter implements Converter<String, Employee> {

    @Override
    public Employee convert(String from) {
        String[] data = from.split(",");
        return new Employee(Long.parseLong(data[0]), Double.parseDouble(data[1]));
    }
}