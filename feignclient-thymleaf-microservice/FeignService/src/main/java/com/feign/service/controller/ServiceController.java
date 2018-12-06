package com.feign.service.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feign.service.bean.User;
import com.feign.service.repository.UserRepository;

@RestController
public class ServiceController {
	Logger log = Logger.getLogger(ServiceController.class.getName());

	@Autowired
	private UserRepository repository;

	@GetMapping(path = "/user/{id}")
	public User getUserById(@PathVariable("id") int id) throws Exception {
		return repository.findById(id).get();
	}

	@GetMapping(path = "/all-users")
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	@PostMapping(path = "/add-user", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveUser(@RequestBody User user) {
		repository.save(user);
	}

	@DeleteMapping(path = "/delete-user", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteUser(@RequestBody User user) {
		repository.delete(user);
	}
}
