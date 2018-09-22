package com.tech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tech.entities.Role;
import com.tech.entities.User;
import com.tech.entities.repositories.UserRepositories;

@Service
public class UserService {
	
	@Autowired
	private UserRepositories userRepositories;
	
	public void createUser(User user) {
		BCryptPasswordEncoder  encoder = new  BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword())); 
		Role userRole = new Role("USER");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepositories.save(user);
	}
	
	public void createAdmin(User user) {
		BCryptPasswordEncoder  encoder = new  BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword())); 
		Role userRole = new Role("ADMIN");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepositories.save(user);
	}
	
	public User findOne(String email) {
		
	  return userRepositories.findByEmail(email);
	}

	public boolean isUserPresent(String email) {
		// TODO Auto-generated method stub
		User u=userRepositories.findByEmail(email);
		if(u!=null)
		{
			return true;
		}
		return false;
	}

	public List<User> findAll() {
		return userRepositories.findAll();
	}

	public List<User> findByName(String name) {
		
		return userRepositories.findByNameLike("%"+name+"%");
			}
	

}