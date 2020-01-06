package com.store.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.main.model.Users;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<Users> getAllUsers(){
		
		List<Users> user = new ArrayList<>();
		userRepository.findAll()
		.forEach(user::add);
		return user;
		
	}
	
	public Optional<Users> getUser(String username) {
		
		return userRepository.findById(username);
		
	}
	
	public void addUser(Users user) {
		userRepository.save(user);
	}
	
	public void deleteUser(String username) {
		userRepository.deleteById(username);
	}

}
