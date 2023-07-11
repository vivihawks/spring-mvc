package com.baeldung.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/custom")
public class LoginController {

//    @Resource(name="authenticationManager")
	@Autowired
    private AuthenticationManager authManager;

    public LoginController() {
        super();
    }

    // API

    // custom login

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") final String username, @RequestParam("password") final String password, final HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authReq =
            new UsernamePasswordAuthenticationToken(username, password);
        Authentication auth ;
        try {
         auth = authManager.authenticate(authReq);
        }
        catch(Exception e) {
        	throw new AccessDeniedException("Bad Credentials provided");
        }
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
        HttpSession session = request.getSession(true);
        session.setAttribute("SPRING_SECURITY_CONTEXT", sc);
        if (auth.isAuthenticated())
        	return "homepage";
        else 
        	return "login.html";
    }
   }