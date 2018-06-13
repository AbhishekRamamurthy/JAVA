package com.web.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {

	@GetMapping("/showLoginPage")
	public String showLoginPage() {
		
		return "fancy-login";
	}
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		
		return "access-denied";
	}
}
