package com.springtuto.examples.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class ApplicationContext {

	@Autowired 
	private Environment environment;
	
	@Bean
	public DataSource dataSource(){
		//it's possible to use hard coded values without using environment and the application.properties 
		DriverManagerDataSource dataSource =new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("jdbc.driverClass"));
		dataSource.setUrl(environment.getProperty("jdbc.url"));
		dataSource.setUsername(environment.getProperty("jdbc.username"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));
		return dataSource;
	}
	
	@Bean
	@Qualifier("embedded")
	public DataSource dataSourceEmbedded(){
		EmbeddedDatabaseBuilder builder =new EmbeddedDatabaseBuilder();
		EmbeddedDatabase embeddedDatabase =builder
												.setType(EmbeddedDatabaseType.HSQL)
												.addScript("sql/db-schema.sql")
												.addScript("sql/db-test-data.sql")
												.build();
		return embeddedDatabase;
	}
	
}
