package com.cognizant.academy.spring.mvc.annotations;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice
@Controller
@RequestMapping(value = "/vehicles", method = RequestMethod.GET)

//			http://localhost:8080/appname/vehicles/
public class VehicleController {

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World! This is a response generated from the controller";
    }

//    @RequestMapping(params = {"test"}, headers =  {"unauthenticated"})
    @RequestMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("hello", "message","Hello World from Spring MVC Controller!");
    }

    @GetMapping("/save")
//    @RequestMapping(value="/save", method=RequestMethod.GET)
    public void saveVehicle (@RequestBody Vehicle vehicle) {
    	throw new CustomException();
    }
    @GetMapping("/save2" )
    public void saveVehicle2 () {
    	throw new IllegalArgumentException();
    }

    @RequestMapping("/{id}")
    public String getVehicle(@PathVariable("id") long id) {
    	System.err.println("The id supplied was >>> " );
    	System.err.println( id);
        return "hello";
    }

    @RequestMapping
    public ModelAndView getVehicleByParam(@RequestParam("id") long id) {
        return new ModelAndView("hello", "message","The id that was read from the request param was " + Optional.of(id));
    }

    @RequestMapping("/buy")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public Car buyCar(@RequestParam(defaultValue = "5") int seatCount) {
        return null;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    public void onIllegalArgumentException(IllegalArgumentException exception) {
    }

    @PostMapping("/assemble")
    public void assembleVehicle(@ModelAttribute("vehicle") Vehicle vehicle) {
    }

    @ModelAttribute("vehicle")
    public Vehicle getVehicle() {
        return new Bike();
    }
    

}
