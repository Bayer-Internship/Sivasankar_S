package com.example.shankz.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shankz.students.Students;

public interface StudentRespository extends JpaRepository<Students, Long> {

	Optional<Students> findByEmail(String email);
}
