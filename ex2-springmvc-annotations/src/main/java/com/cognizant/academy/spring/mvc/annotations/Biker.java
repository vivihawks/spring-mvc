package com.cognizant.academy.spring.mvc.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Biker {

    @Autowired
    private Vehicle vehicle;


    @Autowired
    public Biker(
    		@Qualifier("bike") 
    		Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Autowired
    public void setVehicle(
    		@Qualifier("bike") 
    		Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}
