package com.aru.login.springsecurityauthorization.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aru.login.springsecurityauthorization.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User save(User user);

	public User findById(int userId);
	
	public User findByName(String name);

}
