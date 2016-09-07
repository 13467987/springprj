package com.jsprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/index")
	public String home() {

		
		return "/index";
	}
	@RequestMapping(value="/customer")
	public String customer(){
		
		return "/customer/customer";
	}
	
	@RequestMapping(value="/login")
	public String login(){
		
		return "/login/loginForm";
	}
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public void ajaxTest(){
		
	}
	

	
}
