package com.company.springboot.service;

import java.util.List;

import com.company.springboot.model.Task;

public interface TaskService {

	List<Task> getAllTasks();

	Task getTaskById(Integer id);

	void createTask(Task task);

}
