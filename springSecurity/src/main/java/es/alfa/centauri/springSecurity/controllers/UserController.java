package es.alfa.centauri.springSecurity.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.alfa.centauri.springSecurity.model.Datapoint;
import es.alfa.centauri.springSecurity.model.TimeSeriesRepository;
import es.alfa.centauri.springSecurity.model.User;
import es.alfa.centauri.springSecurity.model.UserRepository;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@GetMapping
	public Iterable<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/{name}")
	public User getUser(@PathVariable String name) {
		return userRepository.findByUserName(name);
	}

//	@PostMapping("")
//	public User addUser(@RequestBody User user) {
//		return userRepository.insert(user);
//	}

	@DeleteMapping("/{name}")
	public void addUser(@PathVariable String name) {
		userRepository.deleteByUserName(name);
	}

}
