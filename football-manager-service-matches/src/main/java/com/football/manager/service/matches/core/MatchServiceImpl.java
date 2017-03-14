package com.football.manager.service.matches.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.manager.models.matches.Match;
import com.football.manager.models.matches.MatchScore;
import com.football.manager.service.matches.interfaces.MatchService;
import com.football.manager.service.matches.interfaces.MatchStoreClient;

@Service
public class MatchServiceImpl implements MatchService {

	@Autowired
	private MatchStoreClient storeClient;
	
	@Override
	public Match save(MatchScore matchScore) {
		return storeClient.save(matchScore);
	}

	@Override
	public void delete(int matchId) {
		storeClient.delete(matchId);
	}

	@Override
	public Match getById(int matchId) {
		return storeClient.getById(matchId);
	}

	@Override
	public List<Match> getAllByTeam(int teamId) {
		return storeClient.getAllByTeam(teamId);
	}

	@Override
	public List<Match> getAll() {
		return storeClient.getAll();
	}

}
