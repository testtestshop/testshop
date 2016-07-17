package com.testshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;

import com.testshop.domain.supply.Role;
import com.testshop.service.UserService;

@Configuration
@Import({ WebConfig.class, DBConfig.class, SecurityConfig.class, ListenerConfig.class })
@ComponentScan({
	"com.testshop.domain.*",
	"com.testshop.service.*",
	"com.testshop.repository.*",
	"com.testshop.exception.*",
	"com.testshop.listener.AddUsersOnStaredListener"
})
@Component
public class MainConfig {
}
