package com.feign.client.controller;

import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.feign.client.bean.User;
import com.feign.client.proxy.FeignProxy;

@Controller
public class ClientController {
	Logger log = Logger.getLogger(ClientController.class.getName());

	@Autowired
	private FeignProxy proxy;

	@GetMapping(path = "/")
	public String showSignupForm(User user) throws Exception {
		return "signup";
	}

	@GetMapping(path = "/users/{id}")
	public String getUserById(@PathVariable int id, Model model) throws Exception {
		User user = proxy.getUserById(id);
		model.addAttribute("users", user);
		return "user-list";
	}

	@GetMapping(path = "/users")
	public String getAllUser(Model model) throws Exception {
		List<User> users = proxy.getAllUsers();
		model.addAttribute("users", users);
		return "user-list";
	}

	@PostMapping(path = "/add-user")
	public String saveUser(@Valid User user, BindingResult result, Model model) throws Exception {
		if (result.hasErrors())
			return "signup";
		proxy.saveUser(user);
		model.addAttribute("users", proxy.getAllUsers());
		return "user-list";
	}

	@PostMapping(path = "/update/{id}")
	public String updateUser(@PathVariable int id, @Valid User user, BindingResult result, Model model)
			throws Exception {
		if (result.hasErrors()) {
			user.setId(id);
			return "edit-user";
		}

		proxy.saveUser(user);
		model.addAttribute("users", proxy.getAllUsers());
		return "user-list";
	}

	@GetMapping(path = "/edit/{id}")
	public String getAllUser(@PathVariable int id, Model model) throws Exception {
		User user;

		try {
			user = proxy.getUserById(id);
			model.addAttribute("user", user);
		} catch (Exception e) {
			throw new IllegalArgumentException("No user available with Id: " + id);
		}
		return "edit-user";
	}

	@GetMapping(path = "/delete/{id}")
	public String deleteUser(@PathVariable int id, Model model) throws Exception {
		User user;

		try {
			user = proxy.getUserById(id);
			proxy.deleteUser(user);
			model.addAttribute("users", proxy.getAllUsers());
		} catch (Exception e) {
			throw new IllegalArgumentException("No user available with Id: " + id);
		}
		return "user-list";
	}

}
