package com.microservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults());
		http.csrf(AbstractHttpConfigurer::disable);
		return http.build();
	}

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("admin").password("{noop}123456").roles("SYSTEM");
//	}
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.cors().and().csrf(AbstractHttpConfigurer::disable)
//				.sessionManagement(
//						sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
//				.authorizeHttpRequests(
//						authorizeRequests -> authorizeRequests.requestMatchers(HttpMethod.GET, "/eureka/**")
//								.hasRole("SYSTEM").requestMatchers(HttpMethod.POST, "/eureka/**").hasRole("SYSTEM")
//								.requestMatchers(HttpMethod.PUT, "/eureka/**").hasRole("SYSTEM")
//								.requestMatchers(HttpMethod.DELETE, "/eureka/**").hasRole("SYSTEM").anyRequest()
//								.authenticated())
//				.httpBasic(Customizer.withDefaults());
//		return http.build();
//	}
}
