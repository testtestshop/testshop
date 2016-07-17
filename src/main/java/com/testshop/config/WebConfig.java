package com.testshop.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;

@Configuration
public class WebConfig {
	
//	@Bean(name = "templateEngine")
//	public SpringTemplateEngine templateEngine() {
//		SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
//		
//		Set<IDialect> dSet = new HashSet<>();
//		
//		dSet.add(springSecurityDialect());
//		
//		springTemplateEngine.setAdditionalDialects(dSet);
//		
//		return springTemplateEngine;
//	}
//	
//	@Bean
//	public SpringSecurityDialect springSecurityDialect() {
//		SpringSecurityDialect springSecurityDialect = new SpringSecurityDialect();
//		
//		return springSecurityDialect;
//	}
}