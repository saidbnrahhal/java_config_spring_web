package com.springtuto.examples.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages={"com.springtuto.examples.model.dao"})
@EnableTransactionManagement
@ComponentScan(basePackages="com.springtuto.examples.model.service")
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
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
		//to activate this bean you need @EnableTransactionManagement
		JpaTransactionManager jpaTransactionManager =new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
		DatabasePopulatorUtils.execute(databasePopulator(),dataSource());
		return jpaTransactionManager ;
	}
	 
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean =new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan("com.springtuto.examples.model");//hada rah 3andou lgharad ghir bi entities
		Properties jpaProperties =new Properties();
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		entityManagerFactoryBean.setJpaProperties(jpaProperties);
		return entityManagerFactoryBean;
	}
	@Bean
	public JpaVendorAdapter jpaVendorAdapter(){
		HibernateJpaVendorAdapter jpaVendorAdapter =new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabase(Database.MYSQL);
		jpaVendorAdapter.setShowSql(true);
		return jpaVendorAdapter;
	}
	@Bean
	public DatabasePopulator databasePopulator(){
		/*to activated use DatabasePopulatorUtils.execute(databasePopulator(),dataSource());
		it in JpaTransactionManager*/
		ResourceDatabasePopulator databasePopulator =new ResourceDatabasePopulator();
		databasePopulator.setContinueOnError(true);
		databasePopulator.addScript(new ClassPathResource("sql/db-test-data.sql"));
		return databasePopulator ;
	}
}
