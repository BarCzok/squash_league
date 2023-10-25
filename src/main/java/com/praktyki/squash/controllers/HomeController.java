package com.praktyki.squash.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(value = "/home")
	public String home(ModelMap model){
		return "home";
	}
}
