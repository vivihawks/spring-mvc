package com.baeldung.web.controller;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.baeldung.model.ValidatedPhone;

@Controller
public class ValidatedPhoneController {
	@RequestMapping(value = "500", method = RequestMethod.GET)
	public void throwRuntimeException() {
	    throw new NullPointerException("Throwing a null pointer exception");
	}
	
    @GetMapping("/validatePhone")
    public String loadFormPage(Model m) {
        m.addAttribute("validatedPhone", new ValidatedPhone());
        return "phoneHome";
    }

    @PostMapping("/addValidatePhone")
    public String submitForm(@Valid @ModelAttribute ValidatedPhone validatedPhone, BindingResult result, Model m) {
        if (result.hasErrors()) {
            return "phoneHome";
        }

        m.addAttribute("message", "Successfully saved phone: " + validatedPhone.toString());
        return "phoneHome";
    }

}
