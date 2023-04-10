package com.example.shankz.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.shankz.model.User;
import com.example.shankz.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto userregistrationdto);
}
