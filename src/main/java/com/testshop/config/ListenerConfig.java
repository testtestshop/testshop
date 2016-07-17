package com.testshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.testshop.listener.AddUsersOnStaredListener;

@Configuration
public class ListenerConfig {

	@Bean
	public AddUsersOnStaredListener addUsersOnStaredListener() {
		return new AddUsersOnStaredListener();
	}
	
}
