package com.springsecurity.api;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class Myappsecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource datasource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		auth.jdbcAuthentication()
		    .dataSource(datasource)
		    .withDefaultSchema()
		    .withUser("workers of konnectgen")
		    .password( encoder.encode("konnectgen"))
		    .roles("USER")
		    .and()
		    .withUser("itandhr")
		    .password(encoder.encode("konnectgenFM"))
		    .roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		     .antMatchers("/user").hasAnyRole("USER","ADMIN")
		     .antMatchers("/admin").hasRole("ADMIN")
		     .antMatchers("/").permitAll()
		     .and().formLogin();
	}

}
