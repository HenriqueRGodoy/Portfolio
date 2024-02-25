package com.valdir.os.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.valdir.os.services.DBService;

import jakarta.annotation.PostConstruct;


@Configuration
@Profile("test")
public class TestConfig {
	@Autowired
	private DBService dbService;
	
	@PostConstruct
	public void createInstace() {
		this.dbService.instanciaDB();
	}
}
