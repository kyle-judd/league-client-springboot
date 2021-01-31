package com.kylejudd.leagueclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class LeagueClientApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeagueClientApiApplication.class, args);

	}

	@Bean
	public WebClient getWebClientBuilder() {
		return WebClient.builder().build();
	}

}
