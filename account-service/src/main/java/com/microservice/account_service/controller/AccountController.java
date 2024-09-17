package com.microservice.account_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

	@GetMapping("test")
	public String testAccount() {
		return "testAccount";
	}

	@GetMapping("/admin")
	public String testClient(@RequestParam("name") String name) {
		return name;

	}
}
