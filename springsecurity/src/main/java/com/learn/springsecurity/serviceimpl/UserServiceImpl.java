package com.learn.springsecurity.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.learn.springsecurity.entity.User;
import com.learn.springsecurity.repository.UserRepository;
import com.learn.springsecurity.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	public ArrayList<User> userList=new ArrayList<User>();
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//fake user -- userList
//	public UserServiceImpl()
//	{
//		userList.add(new User("abc","abc","abc@gmail.com"));
//		userList.add(new User("xyz","xyz","xyz@gmail.com"));
//	}

	//get All the Users
	@Override
	public List<User> getAllUser() 
	{
//		return this.userList;
		return this.userRepository.findAll();
	}

	//get a single user based on userName
	@Override
	public User getUser(String userName) 
	{
//		return this.userList.stream()
//							.filter(user->user.getUserName().equals(userName))
//							.findAny()
//							.orElse(null);
		return this.userRepository.findByUserName(userName);
	}

	//to add new user in userList
	@Override
	public User addUser(User user) 
	{
//		this.userList.add(user);
		user.setEmail("trusha@gmail.com");
		user.setPassword(this.bCryptPasswordEncoder.encode("trusha"));
		user.setUserName("trusha");
		user.setRole("ROLE_NORMAL");
		this.userRepository.save(user);
		return user;
	}
}
