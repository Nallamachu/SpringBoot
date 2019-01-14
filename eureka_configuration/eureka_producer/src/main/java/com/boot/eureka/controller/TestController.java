package com.boot.eureka.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping(path = "/")
	public List<String> fetchNames() {
		return Arrays.asList("Subbareddy", "Nallamachu", "JavaIsOcean", "JavaTBrains");
	}

}
