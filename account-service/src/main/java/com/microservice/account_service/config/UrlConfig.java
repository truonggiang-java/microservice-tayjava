package com.microservice.account_service.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@ConfigurationProperties(prefix = "url")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrlConfig {
	private List<ServerName> servers;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class ServerName {
		private String ip;
		private String name;
	}
}
