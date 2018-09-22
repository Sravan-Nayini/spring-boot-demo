package com.tech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.entities.Task;
import com.tech.entities.User;
import com.tech.entities.repositories.TaskRepositories;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepositories taskRepository;
	
	public void addTask(Task task, User user) {
		task.setUser(user);
		taskRepository.save(task);
	}
	
	public List<Task>  findUserTask(User user){
		
		return taskRepository.findByUser(user);
	}

}