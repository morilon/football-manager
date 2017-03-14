package com.football.manager.service.matches.interfaces;

import java.util.List;

import com.football.manager.configurations.ContentTypes;
import com.football.manager.configurations.endpoints.MatchEndpoints;
import com.football.manager.models.matches.Match;
import com.football.manager.models.matches.MatchScore;

import feign.Headers;
import feign.RequestLine;

public interface MatchStoreClient {

	@RequestLine("POST " + MatchEndpoints.SAVE)
	@Headers(ContentTypes.APPLICATION_JSON)
	Match save(MatchScore matchScore);
	
	@RequestLine("DELETE " + MatchEndpoints.DELETE)
	@Headers(ContentTypes.APPLICATION_JSON)
	void delete(int matchId);
	
	@RequestLine("GET " + MatchEndpoints.GET_BY_ID)
	@Headers(ContentTypes.APPLICATION_JSON)
	Match getById(int matchId);
	
	@RequestLine("GET " + MatchEndpoints.GET_ALL_BY_TEAM)
	@Headers(ContentTypes.APPLICATION_JSON)
	List<Match> getAllByTeam(int teamId);
	
	@RequestLine("GET " + MatchEndpoints.GET_ALL)
	List<Match> getAll();
}