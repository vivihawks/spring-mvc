package com.baeldung.web.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baeldung.model.Employee;

@Controller
public class EmployeeController {

    Map<Long, Employee> employeeMap = new HashMap<>();

    @ModelAttribute("employees")
    public Map initEmployees() {
    	System.err.println(">>>------> Inside initEmployees");
        employeeMap.put(1L, new Employee(1L, "John", "223334411", "rh"));
        employeeMap.put(2L, new Employee(2L, "Peter", "22001543", "informatics"));
        employeeMap.put(3L, new Employee(3L, "Mike", "223334411", "admin"));
        return employeeMap;
    }
    
    //consumes === content-type header
    //produces === accept
    @PostMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, String> test(@RequestBody Employee employee) {
    	System.err.println("Employee name is ");
    	System.err.println(Optional.of(employee.getName()));
        return Collections.singletonMap("key", "value");
    }

 
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ModelAndView showForm() {
    	System.err.println(">>>------> Inside showForm");
//    	
//    	if (id !=0) {
//    		//Get the employee from the database
//    	}
//    	else {
//    		//Create a blank employee object
//    	}
////    	return new ModelAndView("employeeHome", "book", new EmployeeBook());
//    	return new ModelAndView("employeeHome", "book", new Book());
    	
        return new ModelAndView("employeeHome", "employee", new Employee());
    }//comment

    @RequestMapping(value = "/employee/{Id}", produces = { "application/json", "application/xml" }, method = RequestMethod.GET)
    public @ResponseBody Employee getEmployeeById(@PathVariable final Long Id) {
    	System.err.println(">>>------> Inside getEmpById");
        return employeeMap.get(Id);
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String submit(@ModelAttribute("employee") final Employee employee, final BindingResult result, final ModelMap model) {
    	System.err.println(">>>------> Inside submit");
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());
        model.addAttribute("workingArea", employee.getWorkingArea());
        model.addAttribute("id", employee.getId());

        employeeMap.put(employee.getId(), employee);

        return "employeeView";
    }

    @ModelAttribute
    public void addAttributes(final Model model) {
    	System.err.println(">>>------> Inside addAttr");
        model.addAttribute("msg", "Welcome to the Netherlands!");
    }
}
