package com.example.shankz.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/login")
	public String login(Model model) {
		return "Login";
	}

	@GetMapping("/")
	public String home(Model model) {
		return "index";
	}
}
