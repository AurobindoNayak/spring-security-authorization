package com.aru.login.springsecurityauthorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aru.login.springsecurityauthorization.dao.UserRepository;
import com.aru.login.springsecurityauthorization.dto.User;

@RestController
public class UserController {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		String pwd = encoder.encode(user.getPassword());
		user.setPassword(pwd);
		repo.save(user);
		return user;
	}

	@GetMapping("/user/{id}")
	public User findbyId(@PathVariable int id) {
		User user = repo.findById(id);
		return user;
	}

}
