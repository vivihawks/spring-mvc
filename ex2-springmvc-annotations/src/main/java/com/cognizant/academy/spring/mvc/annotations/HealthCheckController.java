package com.cognizant.academy.spring.mvc.annotations;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController

// @RestController = @Controller + @ResponseBody

//		OR

//@Controller
//@ResponseBody

public class HealthCheckController {

    private static final String STATUS = "UP";
    
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok(STATUS);
    }
}
