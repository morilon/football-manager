package com.football.manager.service.teams.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.football.manager.configurations.endpoints.TeamEndpoints;
import com.football.manager.service.teams.interfaces.TeamStoreClient;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

@Configuration
public class TeamStoreFeignClientConfiguration {
	
	@Bean
	public TeamStoreClient getMovieStoreClient() {
		return Feign
				.builder()
				.encoder(new JacksonEncoder())
				.decoder(new JacksonDecoder())
				.target(TeamStoreClient.class, TeamEndpoints.STORE_URL);
	}

}
