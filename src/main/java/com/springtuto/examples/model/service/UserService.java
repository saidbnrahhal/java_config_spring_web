package com.springtuto.examples.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springtuto.examples.model.User;
import com.springtuto.examples.model.dao.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;


	public void save(User user){
		userRepository.save(user);
	}
	public List<User> findAll(){
		return userRepository.findAll();
	}
	public void delete(Long id){
		userRepository.delete(id);
	}
}
