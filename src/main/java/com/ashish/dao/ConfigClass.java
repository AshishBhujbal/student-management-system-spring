package com.ashish.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.ashish.dao", "com.ashish.entity*" })
public class ConfigClass {

	@Bean
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("ashish").createEntityManager();
	}
}
