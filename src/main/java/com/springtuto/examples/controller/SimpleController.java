package com.springtuto.examples.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springtuto.examples.model.User;
import com.springtuto.examples.model.service.UserService;

@Controller
public class SimpleController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="simple",method=RequestMethod.GET)
	public String getSimplePage(){
		return "simple";
	}
	
	@RequestMapping(value="userservice",method=RequestMethod.GET)
	public String testUserService(){
		
		User user =new User();
		user.setUsername("conan");
		user.setPassword("password");
		userService.save(user);
		
		List<User> users =userService.findAll();
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).getUsername());
		}
		return "simple";
	}
}
