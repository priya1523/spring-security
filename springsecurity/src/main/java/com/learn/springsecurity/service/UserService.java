package com.learn.springsecurity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.springsecurity.entity.User;

@Service
public interface UserService 
{	
	//get All the Users
	public List<User> getAllUser();
	
	//get a single user based on userName
	public User getUser(String userName);
	
	//to add new user in userList
	public User addUser(User user);
}
