package com.wengs.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@RequestMapping("hello")
	public String hello(@RequestParam("user") String user, Model model) {
		model.addAttribute("user", user);
		return "hello";
	}
}
