package com.learn.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.learn.springsecurity.entity.User;
import com.learn.springsecurity.repository.UserRepository;

@SpringBootApplication
public class SpringsecurityApplication implements CommandLineRunner
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) 
	{
		SpringApplication.run(SpringsecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		User user=new User();
		user.setUserName("priya");
		user.setEmail("priya@gmail.com");
		user.setPassword(this.bCryptPasswordEncoder.encode("priya"));
		user.setRole("ROLE_NORMAL");
		this.userRepository.save(user);
		
		User user1=new User();
		user1.setUserName("ankush");
		user1.setEmail("ankush@gmail.com");
		user1.setPassword(this.bCryptPasswordEncoder.encode("ankush"));
		user1.setRole("ROLE_ADMIN");
		this.userRepository.save(user1);
		
	}

}
