package com.learn.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController 
{
	@GetMapping("/signin")
//	@RequestMapping(method = RequestMethod.GET,value = "/signin")
	public String signIn()
	{
		return "login.html";
	}
}
