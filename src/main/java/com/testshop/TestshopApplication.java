package com.testshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.testshop.config.WebConfig;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@Import({ WebConfig.class })
public class TestshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestshopApplication.class, args);
	}
}
