package com.cts.academy.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

//	@Autowired
//	private UserService userService;
	@RequestMapping("/helloworld")
	@ResponseBody
	public String hello() {
		return "Hello world";
	}

	@RequestMapping("/helloagain")
	public ModelAndView hello2() {
		String helloWorldMessage = "Hello World! again!!!";
		return new ModelAndView("hello", "message", helloWorldMessage);
		
	}
}
//Protocol 	http://
//Host and Port	localhost:8080/
//Application on the sserver 	ex1-springmvc-helloworld
//Application Root	/
//url	helloworld


//	