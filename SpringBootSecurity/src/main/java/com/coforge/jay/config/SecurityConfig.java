package com.coforge.jay.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("Jay").password("{noop}Sippy").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("Bebu").password("{noop}Sippu").roles("USER");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.csrf().disable();
		
		//Security for all API
	//	http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
		
		//Security Based on URL
	//    http.authorizeRequests().antMatchers("/rest/auth/**").fullyAuthenticated().and().httpBasic();
		
		//security Based on ROLE
          http.authorizeRequests().antMatchers("/rest/auth/**").hasRole("ADMIN").anyRequest().fullyAuthenticated().and().httpBasic();
	}

}
