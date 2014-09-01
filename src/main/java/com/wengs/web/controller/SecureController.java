package com.wengs.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="secure")
public class SecureController {
	
	@RequestMapping("demo")
	public String demo(Model model){
		model.addAttribute("a1", "Secure Demo Hello!");
		return "securedemo";
	}
}
