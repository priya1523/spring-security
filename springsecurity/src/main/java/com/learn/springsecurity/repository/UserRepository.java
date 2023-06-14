package com.learn.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.learn.springsecurity.entity.User;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User,String>
{

	public User findByUserName(String username);

}
