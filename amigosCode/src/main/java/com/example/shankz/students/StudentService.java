package com.example.shankz.students;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.shankz.respository.StudentRespository;

@Service
public class StudentService {
	public final StudentRespository studentrepo;

	public StudentService(StudentRespository studentrepo) {
		this.studentrepo = studentrepo;
	}

	public List<Students> getStudents() {
		return studentrepo.findAll();
	}

	public void registerNewStudent(Students student) {
		Optional<Students> option=studentrepo.findByEmail(student.getEmail());
		if(option.isPresent()) {
			throw new IllegalArgumentException("email already exist");
		}
		studentrepo.save(student);
	}

	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		boolean b= studentrepo.existsById(id);
		if(!b) {
			throw new IllegalStateException("student not found");
		}
		studentrepo.deleteById(id);
	}
}
