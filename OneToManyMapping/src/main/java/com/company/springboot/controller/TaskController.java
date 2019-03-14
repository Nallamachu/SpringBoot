package com.company.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.springboot.model.Task;
import com.company.springboot.service.TaskService;
import com.company.springboot.service.impl.TaskServiceImpl;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	TaskService taskService;
	
	@GetMapping("/all")
	public List<Task> getAllTasks(){
		return taskService.getAllTasks();
	}
	
	@GetMapping("/{id}")
	public Task getAllTasks(@PathVariable Integer id){
		return taskService.getTaskById(id);
	}
	
	@PostMapping("/save")
	public void saveTask(@RequestBody Task task) {
		taskService.createTask(task);
	}
	
	@Bean
	public TaskService getInstance() {
		TaskService service = new TaskServiceImpl();
		return service;
	}
}
