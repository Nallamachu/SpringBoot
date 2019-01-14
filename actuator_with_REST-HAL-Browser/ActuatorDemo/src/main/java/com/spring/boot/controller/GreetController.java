package com.spring.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	@GetMapping(path = "/greet")
	public String greet() {
		return "Hey buddy... Welcome to SpringBoot";
	}

	@GetMapping(path = "/greet/{name}")
	public String greet(@PathVariable String name) {
		return "Hey " + name + "... Welcome to SpringBoot";
	}

}
