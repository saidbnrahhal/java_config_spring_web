package com.springtuto.examples.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 
 * Configuration class =dispatcher-servlet.xml
 * 
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages=("com.springtuto.examples.controller"))
public class WebConfig extends WebMvcConfigurerAdapter{

	
	 @Override
	 public void addViewControllers(ViewControllerRegistry registry){
		 //form the link to jsp without passing by controller
		 //we right just index not index.jsp because of
		 //the internalResourceViewResolver will managed
		 registry.addViewController("/").setViewName("index");
	 }
	
	 @Bean
	 public InternalResourceViewResolver internalResourceViewResolver(){
		 InternalResourceViewResolver resolver =new InternalResourceViewResolver();
		 resolver.setPrefix("/WEB-INF/pages/");
		 resolver.setSuffix(".jsp");
		 return resolver;
	 }
	 @Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry){
		 registry.addResourceHandler("*/resources/**").addResourceLocations("/resources/");
	 }
}