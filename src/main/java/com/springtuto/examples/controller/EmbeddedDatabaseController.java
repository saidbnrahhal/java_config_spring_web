package com.springtuto.examples.controller;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmbeddedDatabaseController {

	private static final Logger LOGGER =LoggerFactory.getLogger(EmbeddedDatabaseController.class);
	@Autowired
	private DataSource dataSource ;
	
	private JdbcTemplate jdbcTemplate ;
	
	@RequestMapping(value="/testsql",method=RequestMethod.GET)
	public void displayUsers(){
		
		jdbcTemplate =new JdbcTemplate(dataSource);
		List<Map<String, Object>> list =jdbcTemplate.queryForList("SELECT * FROM USER");
		
		for (Map<String, Object> user : list) {
			LOGGER.debug("user name :"+user.get("username"));
		}
	}
	
}
