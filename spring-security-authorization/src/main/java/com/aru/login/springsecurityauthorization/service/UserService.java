package com.aru.login.springsecurityauthorization.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aru.login.springsecurityauthorization.dao.UserRepository;
import com.aru.login.springsecurityauthorization.dto.User;



@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = dao.findByName(username);
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
				new ArrayList<>());
	}

}
