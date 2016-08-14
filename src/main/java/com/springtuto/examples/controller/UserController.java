package com.springtuto.examples.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springtuto.examples.model.Authority;
import com.springtuto.examples.model.User;
import com.springtuto.examples.model.service.AuthorityService;
import com.springtuto.examples.model.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService ;
	
	@Autowired
	AuthorityService authorityService ;
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public String getUserPage(Model model){
		User user =new User();
		List<User> users =userService.findAll();
		model.addAttribute("users",users);
		model.addAttribute("user",user);
		return "users";
	}
	@RequestMapping(value="/users",method=RequestMethod.POST)
	public String addUserAction(@ModelAttribute User user){
		user.setEnabled(true);
		userService.save(user);
		return "redirect:users";
	}
	@RequestMapping(value="/authorities",method=RequestMethod.GET)
	public String getAuthoritiesPage(Model model){
		Authority authority =new Authority();
		List<Authority> authorities =authorityService.findAll();
		model.addAttribute("authorities",authorities);
		model.addAttribute("authority",authority);
		return "authorities";
	}
	@RequestMapping(value="/authorities",method=RequestMethod.POST)
	public String addAuthoritiesAction(@ModelAttribute Authority authority){
		
		authorityService.save(authority);
		return "redirect:authorities";
	}
	@RequestMapping(value ="/user" ,method=RequestMethod.GET)
	public String getUserPage(){
		
		return "user/index";
	}
	@RequestMapping(value="/admin" ,method=RequestMethod.GET)
	public String getAdminPage(){
		return "admin/index";
	}
}
