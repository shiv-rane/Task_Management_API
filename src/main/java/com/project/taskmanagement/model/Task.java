package com.project.taskmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	private String description;
	private boolean completed;
	
	public Task(long id, String title, String description, boolean completed) {
		this.id=id;
		this.title=title;
		this.description=description;
		this.completed=completed;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id=id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description=description;
	}
	
	public boolean getisCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed=completed;
	}
}
