package com.example.shankz.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.shankz.service.UserService;
import com.example.shankz.web.dto.UserRegistrationDto;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	@Autowired
	private UserService userservice;
	@GetMapping
	public String registerLoad(Model model,UserRegistrationDto registerdto ,BindingResult result) {
		if (result.hasErrors()) {
			return "index";
		}
		model.addAttribute("user", registerdto);
		return "Registration";
	}
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto userregisterdto,Model model, BindingResult result) {
		if (result.hasErrors()) {
			return "index";
		}
		userservice.save(userregisterdto);
		return "redirect:/success";
		
	}

}
