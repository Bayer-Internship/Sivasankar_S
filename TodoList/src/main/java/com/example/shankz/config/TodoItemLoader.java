package com.example.shankz.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.shankz.model.TodoListModel;
import com.example.shankz.repository.TodoRepository;

@Component
public class TodoItemLoader implements CommandLineRunner {
	private final Logger logger = LoggerFactory.getLogger(TodoItemLoader.class);
	@Autowired
	private TodoRepository todorepo;

	public void run(String... args) throws Exception {
		loaddata();
	}

	private void loaddata() {
		// TODO Auto-generated method stub
		if (todorepo.count() == 0) {
			TodoListModel todolist = new TodoListModel("Take a Long breath");
			todorepo.save(todolist);
		}
		logger.info("The number of todo item: {}" + todorepo.count());
	}

}
