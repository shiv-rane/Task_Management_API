package com.project.taskmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.taskmanagement.model.Task;
import com.project.taskmanagement.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping
	public ResponseEntity<Task> createTask(@RequestBody Task task){
		Task createdTask = taskService.createTask(task);
		return new ResponseEntity<>(createdTask,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Task>> getAllTasks(){
		
		List<Task> tasks = taskService.getAllTasks();
		return new ResponseEntity<>(tasks,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable Long id){
		Optional<Task> task = taskService.getTaskById(id);
		return task.map(t ->  new ResponseEntity<>(t,HttpStatus.OK))
				.orElseGet(() ->  new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task){
		Task updatedTask = taskService.updateTask(id, task);
		return updatedTask != null ? new ResponseEntity<>(updatedTask,HttpStatus.OK)
								   : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Task> deleteTask(@PathVariable Long id){
		taskService.deleteTask(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
