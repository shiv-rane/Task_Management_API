package com.project.taskmanagement.service;

import java.util.List;
import java.util.Optional;

import com.project.taskmanagement.model.Task;

public interface TaskService {
	Task createTask(Task task);
	List<Task> getAllTasks();
	Optional<Task> getTaskById(Long id);
	Task updateTask(Long id, Task task);
	void deleteTask(Long id);
}
