package com.testshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.testshop.service.AuthUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("authUserDetailsService")
	private UserDetailsService authUserDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authUserDetailsService);//temporaly disabled .passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/login", "/", "/index**", "/j_spring_security_check", "/j_spring_security_logout", "/api/login**", "/403**").permitAll()
			.antMatchers("/css/**", "/js/**","/fonts/**","/img/**").permitAll()
			.antMatchers(HttpMethod.GET, "/api/item").permitAll()
			.antMatchers(HttpMethod.GET, "/api/task/user/**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
			.antMatchers("/api/user**").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/api/task**", "/api/task/**", "/api/item**").access("hasRole('ROLE_ADMIN')")
			.antMatchers(HttpMethod.POST, "/api/task/order").access("hasRole('ROLE_USER')")
			.antMatchers("/**").denyAll()
			
			.and()
			.formLogin()
				.loginPage("/index")
				.failureUrl("/index?error")
				.loginProcessingUrl("/j_spring_security_check")
				.usernameParameter("username")
				.passwordParameter("password")
			.and()
			.logout()
				.logoutSuccessUrl("/index")
				.logoutUrl("/j_spring_security_logout")
				.invalidateHttpSession(true)
			.and()
				.csrf()
			.and()
				.exceptionHandling().accessDeniedPage("/403");
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}
