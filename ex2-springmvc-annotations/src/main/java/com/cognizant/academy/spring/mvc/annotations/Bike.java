package com.cognizant.academy.spring.mvc.annotations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
//@DependsOn
@Qualifier("bike")
public class Bike implements Vehicle {
	@Value("Yellow")
    private String color;

//    @Required
    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

}
