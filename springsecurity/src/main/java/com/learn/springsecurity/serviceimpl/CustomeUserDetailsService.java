package com.learn.springsecurity.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learn.springsecurity.entity.CustomeUserDetails;
import com.learn.springsecurity.entity.User;
import com.learn.springsecurity.repository.UserRepository;

@Service
public class CustomeUserDetailsService implements UserDetailsService
{
	@Autowired
	private UserRepository userRepository;

	//it check the user to authenticate
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user=this.userRepository.findByUserName(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("No User Found With "+username);
		}
		return new CustomeUserDetails(user);
	}
	
}
