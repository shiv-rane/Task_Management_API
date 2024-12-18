package com.project.taskmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.taskmanagement.model.Task;
import com.project.taskmanagement.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public Task createTask(Task task) {
		// TODO Auto-generated method stub
		return taskRepository.save(task);
	}

	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return taskRepository.findAll();
	}

	@Override
	public Optional<Task> getTaskById(Long id) {
		// TODO Auto-generated method stub
		return taskRepository.findById(id);
	}

	@Override
	public Task updateTask(Long id, Task task) {
		// TODO Auto-generated method stub
		Optional<Task> existingTask = taskRepository.findById(id);
		try {
		if(existingTask.isPresent()) {
		Task updatedTask = existingTask.get();
		updatedTask.setTitle(task.getTitle());
		updatedTask.setDescription(task.getDescription());
		updatedTask.setCompleted(task.getisCompleted());
		return taskRepository.save(updatedTask);
		}
		}catch(Exception e) {
			System.out.println("Cannot update");
		}
	return null;	
	}

	@Override
	public void deleteTask(Long id) {
		// TODO Auto-generated method stub
		taskRepository.deleteById(id);
	}
	
}
