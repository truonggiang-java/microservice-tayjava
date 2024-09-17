package com.microservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.client.AccountClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RefreshScope
@RequiredArgsConstructor
public class AuthenticationController {

	private final AccountClient accountClient;

	@Value("${spring.config.test}")
	private String springConfigTest;


	@GetMapping("/test/{name}")
	@CircuitBreaker(name = "testCall", fallbackMethod = "fallbackTestCallAPi")
	@SecurityRequirements
	public String testCallApi(@PathVariable("name") String name) {
		return "Hello " + accountClient.testClient(name);
	}
	
	public String fallbackTestCallAPi(Throwable throwable) {
		System.out.println("234");
		return "Có lỗi xảy ra  bạn vui lòng thử lại";
	}
	@GetMapping("/test123")
	public String test() {
		System.out.println("123");
		return "Hello world" ;
	}
}
