package com.football.manager.service.matches.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.football.manager.configurations.endpoints.MatchEndpoints;
import com.football.manager.service.matches.interfaces.MatchStoreClient;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

@Configuration
public class MatchStoreFeignClientConfiguration {

	@Bean
	public MatchStoreClient getStoreClient() {
		return Feign
				.builder()
				.encoder(new JacksonEncoder())
				.decoder(new JacksonDecoder())
				.target(MatchStoreClient.class, MatchEndpoints.STORE_URL);
	}
}
