package com.company.springboot.service;


import com.company.springboot.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
	
	Optional<User> findById(int id);

	User findByName(String name);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUserById(int id);

	void deleteAllUsers();

	List<User> findAllUsers();

	boolean isUserExist(User user);
}