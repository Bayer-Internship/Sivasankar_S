package com.example.shankz.controller;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.shankz.model.TodoListModel;
import com.example.shankz.repository.TodoRepository;
import com.example.shankz.service.TodoService;

import jakarta.validation.Valid;

@Controller
public class TodoListController {
	@Autowired
	private TodoService todoservice;
	@Autowired
	private TodoRepository todorepo;
	private final Logger logger = LoggerFactory.getLogger(TodoListController.class);

	@GetMapping("/")
	public String index(Model model) {
		logger.warn("getting elements");
		model.addAttribute("todoItems", todoservice.getElement());
		return "index";
	}

	@GetMapping("/edit/{id}")
	public String editTodo(@PathVariable("id") Long id, Model model) {
		logger.warn("editing");
		model.addAttribute("todoItems", todoservice.updateElement(id));
		logger.warn("editing");
		return "Update";

	}

	@PostMapping("/todo/{id}")
	public String updateTodo(@PathVariable("id") Long id, Model model, @Valid TodoListModel todo,
			BindingResult result) {
		if (result.hasErrors()) {
			todo.setId(id);
			return "Update";
		}
		todo.setModifiedtime(LocalDate.now());
		boolean s=todo.isCompleted();
		todo.setStatus(s);
		todorepo.save(todo);
		return "redirect:/";

	}

	@GetMapping("/createtodo")
	public String showAddTodoForm(TodoListModel todoitem, Model model) {
		model.addAttribute("todoItems", todoitem);
		return "addTodo";
	}

	@PostMapping("/todo")
	public String addTodo(Model model, @Valid TodoListModel todo, BindingResult result) {
		if (result.hasErrors()) {
			return "addTodo";
		}
		todo.setModifiedtime(LocalDate.now());
		todo.setCreatedtime(LocalDate.now());
		boolean s=todo.isCompleted();
		todo.setStatus(s);
		todorepo.save(todo);
		return "redirect:/";

	}

	@GetMapping("/delete/{id}")
	public String deleteTodo(@PathVariable("id") Long id, Model model) {
		logger.warn("working");
		TodoListModel todo = todorepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("couldn't find the id"));
		todorepo.delete(todo);
		return "redirect:/";
	}

}
