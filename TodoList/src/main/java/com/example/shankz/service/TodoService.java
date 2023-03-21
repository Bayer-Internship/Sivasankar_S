package com.example.shankz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shankz.exception.TodoException;
import com.example.shankz.model.TodoListModel;
import com.example.shankz.repository.TodoRepository;


@Service
public class TodoService {
	 private TodoRepository todorepo;
	@Autowired
	public TodoService(TodoRepository todorepo) {
		this.todorepo = todorepo;
	}
	public List<TodoListModel> getElement() {
		// TODO Auto-generated method stub
		return  todorepo.findAll();
	}
	public TodoListModel updateElement(Long id) {
		// TODO Auto-generated method stub
		TodoListModel todo=todorepo.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("couldn't find the id"));
		return todo;
	}

}
