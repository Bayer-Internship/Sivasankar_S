package com.example.shankz.students;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Students {
	@Id
	@SequenceGenerator(
			name = "student_sequence",
			sequenceName = "student_sequence",
			allocationSize = 1)
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private String email;
	private LocalDate dob;
	@Transient
	private Integer age;

	public Students() {
	}

	public Students(Long id, String name, String email, LocalDate dob) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
	}

	public Students(String name, String email, LocalDate dob) {
		this.name = name;
		this.email = email;
		this.dob = dob;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Integer getAge() {
		return Period.between(this.dob, LocalDate.now()).getYears();
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + "\n" + ", name=" + name + "\n" + ", email=" + email + "\n" + ", dob=" + dob + "\n"
				+ ", age=" + age + "]";
	}

}
