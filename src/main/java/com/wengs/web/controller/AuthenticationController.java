package com.wengs.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "authentication")
public class AuthenticationController {

	@RequestMapping(value = "logout")
	public String logout() {
		return "redirect:/j_spring_security_logout";
	}
}
