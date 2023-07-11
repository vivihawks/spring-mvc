package com.baeldung.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baeldung.model.Company;

@Controller
//@RequestMapping(value = "/abc")
public class CompanyController {

    Map<Long, Company> companyMap = new HashMap<>();

    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("companyHome", "company", new Company());
    }

    // http://host:port/contextRoot/company/24ewt
    @RequestMapping(value = "/company/{Id}", produces = { "application/json", "application/xml" }, method = RequestMethod.GET)
    public @ResponseBody Company getCompanyById(@PathVariable final long Id) {
    	System.err.println("*** /company/{Id} is called");
        companyMap.put(Id, new Company(Id,"Toyota"));

    	return companyMap.get(Id);
    }

    @RequestMapping(value = "/addCompany", method = RequestMethod.POST)
    public String submit(@ModelAttribute("company") final Company company, final BindingResult result, final ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("name", company.getName());
        model.addAttribute("id", company.getId());

        companyMap.put(company.getId(), company);

        return "companyView";
    }

//    	  /companyEmployee/id=2;name=Xpto/employeeData/id=1;name=John;contactNumber=2200112334
    @RequestMapping(value = "/companyEmployee/{company}/employeeData/{employee}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, String>> getEmployeeDataFromCompany(@MatrixVariable(pathVar = "employee") final Map<String, String> matrixVars) {
        return new ResponseEntity<>(matrixVars, HttpStatus.OK);
    }

    
//    	  /companyData/id=2;name=Xpto/employeeData/id=1;name=John;contactNumber=2200112334
    @RequestMapping(value = "/companyData/{company}/employeeData/{employee}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, String>> getCompanyName(@MatrixVariable(value = "name", pathVar = "company") final String name) {
        final Map<String, String> result = new HashMap<String, String>();
        result.put("name", name);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
