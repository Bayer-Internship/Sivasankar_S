package com.example.shankz.students;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
	private final StudentService studentservice;

	@Autowired
	public StudentController(StudentService studentservice) {
		this.studentservice = studentservice;
	}

	@GetMapping(path = "find")
	public List<Students> getStudents() {
		return studentservice.getStudents();
	}

	@PostMapping(path = "add")
	public void registerNewStudent(@RequestBody Students student) {
		studentservice.registerNewStudent(student);
	}
	@DeleteMapping(path = "delete/{studentid}")
	public void deleteStudent(@PathVariable("studentid") Long id) {
		studentservice.deleteStudent(id);
	}

}
