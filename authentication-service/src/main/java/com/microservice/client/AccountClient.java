package com.microservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ACCOUNT", path = "${path.account}", url = "${url.account}")
public interface AccountClient {

	@GetMapping("/admin")
	public String testClient(@RequestParam("name") String name);
}
