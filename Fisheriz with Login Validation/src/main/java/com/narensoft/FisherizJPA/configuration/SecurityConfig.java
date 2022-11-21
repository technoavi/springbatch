package com.narensoft.FisherizJPA.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class SecurityConfig {
	
	
	//Authorization
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		    
		    .authorizeHttpRequests((request) -> request
		    		.antMatchers("/*", "/").permitAll()
		    		.anyRequest().authenticated()
		    )
		    .csrf().disable()
		    .httpBasic(withDefaults());
		
		    return http.build();
	}
	
	//Authentication
	

}
