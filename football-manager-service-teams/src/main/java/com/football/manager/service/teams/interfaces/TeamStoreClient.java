package com.football.manager.service.teams.interfaces;

import java.util.List;

import com.football.manager.configurations.ContentTypes;
import com.football.manager.configurations.endpoints.TeamEndpoints;
import com.football.manager.models.teams.Team;

import feign.Headers;
import feign.RequestLine;

public interface TeamStoreClient {
	
	@RequestLine("GET " + TeamEndpoints.GET_ALL)
	List<Team> getAll();
	
	@RequestLine("GET " + TeamEndpoints.GET_BY_ID)
	@Headers(ContentTypes.APPLICATION_JSON)
	Team getById(int teamId);
}
