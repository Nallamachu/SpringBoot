package com.json.schema.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.json.schema.model.Address;

@RestController
@RequestMapping("/json/schema")
public class JsonSchemaValidationController {

	@PostMapping(path = "/validation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBody validataSchema(@RequestBody @Valid Address address) {
		try {
			new ResponseEntity<>(address, HttpStatus.OK);
		} catch (Exception e) {
			new ResponseEntity<>("Validation Failed", HttpStatus.BAD_REQUEST);
		}
		return null;
	}

}
