package com.feign.client.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.feign.client.bean.User;

@FeignClient(name = "feign", url = "localhost:3030")
public interface FeignProxy {
	@GetMapping(path = "/user/{id}")
	public User getUserById(@PathVariable("id") int id) throws Exception;

	@GetMapping(path = "/all-users")
	public List<User> getAllUsers();

	@PostMapping(path = "/add-user", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveUser(@RequestBody User user);

	@DeleteMapping(path = "/delete-user", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteUser(@RequestBody User user);
}
