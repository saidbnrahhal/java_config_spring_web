package com.springtuto.examples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SimpleController {

	@RequestMapping(value="simple",method=RequestMethod.GET)
	public String getSimplePage(){
		return "simple";
	}
	
}
