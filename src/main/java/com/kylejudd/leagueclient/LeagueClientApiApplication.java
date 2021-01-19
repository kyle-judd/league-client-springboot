package com.kylejudd.leagueclient;

import com.kylejudd.leagueclient.com.kylejudd.leagueclient.CONTROLLERS.RestTemplateResponseErrorHandler;
import com.kylejudd.leagueclient.com.kylejudd.leagueclient.DTO.LeagueAccount;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class LeagueClientApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeagueClientApiApplication.class, args);

	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
