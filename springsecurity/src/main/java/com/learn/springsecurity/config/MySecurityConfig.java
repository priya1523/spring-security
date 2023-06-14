package com.learn.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.learn.springsecurity.serviceimpl.CustomeUserDetailsService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	private CustomeUserDetailsService customeUserDetailsService;
	
	//for out custom configuration
	//we want to change the authentication type
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable() //disable to csrf attack security
			.authorizeRequests() //authorize the request
//			.antMatchers("/home","/login","/register") //it match the url with /home except it validate the user for any other url
			//we can pass multiple url also
			.antMatchers("/signin").permitAll()
			.antMatchers("/public/**") //we can give global url also
//			.permitAll() //Permit access to all the users
			.hasRole("NORMAL") //Permit only the user which has role as NORMAL
			.antMatchers("/users/**").hasRole("ADMIN")
			.anyRequest() //any type of request it authorize
			.authenticated() //which request are coming has to be authenticate first
			.and() //and
//			.httpBasic(); //we are using http basic authentication
			.formLogin() //this is for form based authentication
			.loginPage("/signin")//if we want to change the default login page
			.loginProcessingUrl("/dologin")//after login validate with this url same as action in form
			.defaultSuccessUrl("/users/"); //default url for successful login
	}
	
	//we want our own userName and Password
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
//		auth.inMemoryAuthentication() // by inMemoryAuthentication we can change also
//			.withUser("Priya") //userName which we want
////			.password("priya") //password for that user
//			.password(this.passwordEncoder().encode("priya")) //encode the password before storing
//			.roles("NORMAL"); //role which we want to specify for the user
//		
//		auth.inMemoryAuthentication()
//			.withUser("Ankush")
////			.password("ankush")
//			.password(this.passwordEncoder().encode("ankush"))
//			.roles("ADMIN"); //we can give multiple user with same process
		
		// ---------------- After Using Database ----------//
		auth.userDetailsService(this.customeUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
//		return NoOpPasswordEncoder.getInstance(); 
		//it means that we not using any encoder just plain text we are returning
		//but it is not recommend to use at production level
		
		return new BCryptPasswordEncoder(10);
		//it encrypt the password
	}
}
