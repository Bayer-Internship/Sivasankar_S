package com.example.shankz.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shankz.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
