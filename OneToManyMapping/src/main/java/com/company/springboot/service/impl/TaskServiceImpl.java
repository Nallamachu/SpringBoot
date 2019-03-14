package com.company.springboot.service.impl;

import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.company.springboot.model.Task;
import com.company.springboot.repositories.TaskRepository;
import com.company.springboot.service.TaskService;

@Service(name="taskService")
@Transactional
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository repository;

	@Override
	public List<Task> getAllTasks() {
		return repository.findAll();
	}

	@Override
	public Task getTaskById(Integer id) {
		return repository.findById(id).get();
	}

	@Override
	public void createTask(Task task) {
		repository.save(task);
	}

}
