package com.example.shankz.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import lombok.ToString;

@Entity
@Table(name = "TODOITEM")
@ToString
public class TodoListModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	@NotBlank(message = "Description is required")
	public String description;
	public boolean completed;
	public LocalDate createdtime;
	public LocalDate modifiedtime;
	public String status;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public LocalDate getCreatedtime() {
		return createdtime;
	}

	public void setCreatedtime(LocalDate createdtime) {
		this.createdtime = createdtime;
	}

	public LocalDate getModifiedtime() {
		return modifiedtime;
	}

	public void setModifiedtime(LocalDate modifiedtime) {
		this.modifiedtime = modifiedtime;
	}
	

	public String getStatus() {
		return status;
	}

	public void setStatus(boolean completed) {
		if(completed==true) {
			this.status="COMPLETED";
		}
		else {
			this.status="NOT COMPLETED";
		}
	}

	public TodoListModel() {
	}

	public TodoListModel(String description) {
		this.description = description;
		this.completed = false;
		this.createdtime = LocalDate.now();
		this.modifiedtime = LocalDate.now();
		this.status="NOT COMPLETED";

	}


}
