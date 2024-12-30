package com.example.Todos.controller;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Todos.Model.Task;
import com.example.Todos.repository.TaskRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/task")
public class TaskController{

	@Autowired
	private TaskRepository taskRepository;
	
	
	@PostMapping
	public void GetpostTest(@RequestBody Task task){
		task.setUser_id(UserController.user_id);
		taskRepository.save(task);
	}
	
	
	@GetMapping
	public List<Task> sendAllData(){
		List<Task> tempTasks = taskRepository.findAll();
		List<Task> tasks=new ArrayList<>();
		
		for(Task t :tempTasks) {
			if(t.getUser_id()==UserController.user_id)tasks.add(t);
		}
		return tasks;
	}
	
	@PutMapping("/{id}")
	public Task updateTask(@RequestBody Task task,@PathVariable Long id){
		task.setId(id);
		return taskRepository.save(task);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Long id) {
		taskRepository.deleteById(id);
	}
	
	}
