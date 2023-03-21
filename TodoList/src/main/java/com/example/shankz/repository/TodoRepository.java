package com.example.shankz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shankz.model.TodoListModel;

public interface TodoRepository extends JpaRepository<TodoListModel, Long> {
	Optional<TodoListModel> findById(Long id);
}
