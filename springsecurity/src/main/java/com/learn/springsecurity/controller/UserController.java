package com.learn.springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springsecurity.entity.User;
import com.learn.springsecurity.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	//get all users
	@GetMapping("/")
	public List<User> getAllUsers()
	{
		return userService.getAllUser();
	}
	
	//get a single user based on userName 
	@GetMapping("/{userName}")
	public User getUser(@PathVariable(name = "userName") String userName)
	{
		return userService.getUser(userName);
	}
	
	//to add new user in userList
	@PostMapping("/")
	public User addUser(@RequestBody User user)
	{
		return userService.addUser(user);
	}
	
	@PostMapping("/add")
	public User addUser()
	{
		return userService.addUser(new User());
	}
}
