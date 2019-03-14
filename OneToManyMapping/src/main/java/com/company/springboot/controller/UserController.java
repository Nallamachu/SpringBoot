package com.company.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.util.UriComponentsBuilder;

import com.company.springboot.model.User;
import com.company.springboot.service.UserService;
import com.company.springboot.util.CustomErrorType;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/all")
	public List<User> listAllUsers() {
		return userService.findAllUsers();
	}

	@GetMapping("/{id}")
	public Optional<User> getUser(@PathVariable("id") int id) {
		return userService.findById(id);
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		if (userService.findById(user.getId()).isPresent()) {
			return new ResponseEntity<>("Unable to create user. User with id " + user.getId() + " already exist.",
					HttpStatus.CONFLICT);
		}
		userService.saveUser(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") int id, @RequestBody User user) {
		Optional<User> optionUser = userService.findById(id);
		User currentUser = (optionUser.isPresent())?optionUser.get():null;
		if (currentUser == null) {
			return new ResponseEntity<>("Unable to upate. User with id " + id + " not found.", HttpStatus.NOT_FOUND);
		}
		currentUser.setName(user.getName());
		currentUser.setAge(user.getAge());
		currentUser.setSalary(user.getSalary());
		userService.updateUser(currentUser);
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
		Optional<User> optionUser = userService.findById(id);
		User currentUser = (optionUser.isPresent())?optionUser.get():null;
		if (currentUser == null) {
			return new ResponseEntity<>(new CustomErrorType("Unable to delete. User with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		userService.deleteUserById(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/delete/all")
	public ResponseEntity<User> deleteAllUsers() {
		userService.deleteAllUsers();
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

}