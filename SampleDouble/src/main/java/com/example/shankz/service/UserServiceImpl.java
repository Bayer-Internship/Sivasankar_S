package com.example.shankz.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.shankz.model.Role;
import com.example.shankz.model.User;
import com.example.shankz.respository.UserRepository;
import com.example.shankz.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {
	@Lazy
	@Autowired
	private BCryptPasswordEncoder passwordencoder;
	@Autowired
	private UserRepository userrepo;
	

	@Override
	public User save(UserRegistrationDto userregistrationdto) {
		User user =new User(userregistrationdto.getFirstname(), userregistrationdto.getLastname(),
				userregistrationdto.getEmail(),passwordencoder.encode(userregistrationdto.getPassword()), Arrays.asList(new Role("ROLE_USER"))) ;
		return userrepo.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userrepo.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRoleToAuthorities(user.getRoles()));
	}
	private Collection<? extends GrantedAuthority> mapRoleToAuthorities(Collection<Role> roles){
		return roles.stream().map(role-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}
