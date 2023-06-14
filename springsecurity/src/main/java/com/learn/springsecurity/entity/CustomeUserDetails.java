package com.learn.springsecurity.entity;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class CustomeUserDetails implements UserDetails
{
	private User user;
	
	//for get the user
	public CustomeUserDetails(User user)
	{
		this.user=user;
	}

	//give authority based on roles
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		HashSet<SimpleGrantedAuthority> authorities=new HashSet<>();
		authorities.add(new SimpleGrantedAuthority(this.user.getRole()));
		return authorities;
	}

	//get the password from user details
	@Override
	public String getPassword() 
	{
		return this.user.getPassword();
	}

	//get the userName frommuser details
	@Override
	public String getUsername() 
	{
		return this.user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() 
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked() 
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() 
	{
		return true;
	}

	@Override
	public boolean isEnabled() 
	{
		return true;
	}

}
