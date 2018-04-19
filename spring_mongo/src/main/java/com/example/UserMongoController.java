package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserMongoController {

	@Autowired
	private UserMongoRespository repository;

	@GetMapping("/hello")
	public String call() {
		return "Hello Mongo";
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable String id) {
		User user = repository.findById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping("/user/users")
	public ResponseEntity<List<User>> users() {
		List<User> userList = repository.findAll();
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}

	@GetMapping("/user/{name}")
	public ResponseEntity<User> userByName(@PathVariable String name) {
		User user = repository.findByName(name);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping(path = "/save")
	public ResponseEntity<String> save(@RequestBody User document) {
		repository.save(document);
		return new ResponseEntity<String>("record saved", HttpStatus.CREATED);
	}
}
