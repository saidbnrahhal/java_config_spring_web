package com.springtuto.examples.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.springtuto.examples.config.WebConfig;
import com.springtuto.examples.model.User;
import com.springtuto.examples.model.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={WebConfig.class},loader=AnnotationConfigWebContextLoader.class)
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void testUserAdding() {
	 
		long number01 =userService.findAll().size();
		
		User user =new User();
		user.setUsrname("said test");
		user.setPassword("testpass");
		userService.save(user);
		List<User> users =userService.findAll();
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).getUsername());
		}
		assertEquals("there is a porbles",users.size()-1,number01);
	 
	}

}
