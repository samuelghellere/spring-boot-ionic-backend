package com.ghellere.cursomc.config;

import com.ghellere.cursomc.services.DBService;
import com.ghellere.cursomc.services.EmailService;
import com.ghellere.cursomc.services.MockEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	DBService dbService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		dbService.instantiateTestDataba();
	
		return true;
	}

	@Bean
	public EmailService emailService(){
		return new MockEmailService();
	}
}
