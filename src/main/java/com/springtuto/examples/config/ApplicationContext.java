package com.springtuto.examples.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class ApplicationContext {

	@Bean
	public DataSource dataSource(){
		EmbeddedDatabaseBuilder builder =new EmbeddedDatabaseBuilder();
		EmbeddedDatabase embeddedDatabase =builder
												.setType(EmbeddedDatabaseType.HSQL)
												.addScript("sql/db-schema.sql")
												.addScript("sql/db-test-data.sql")
												.build();
		return embeddedDatabase;
	}
	
}
