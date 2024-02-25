package com.valdir.os.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.valdir.os.services.DBService;

import jakarta.annotation.PostConstruct;


@Configuration
@Profile("dev")
public class DevConfig {
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String ddl;
	
	@PostConstruct
	public boolean createInstace() {
		if(ddl.equals("create")) {
			this.dbService.instanciaDB();
		}
		return false;
	}
}
