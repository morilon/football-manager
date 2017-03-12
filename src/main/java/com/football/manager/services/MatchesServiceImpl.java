package com.football.manager.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.football.manager.models.Match;
import com.football.manager.service.interfaces.MatchesService;

@Service
public class MatchesServiceImpl implements MatchesService {

	@Override
	public void save(Match match) {
		// Not implemented
	}

	@Override
	public Match getInfo(int matchId) {
		
		return null;
	}

	@Override
	public List<Match> getAllByTeam(int teamId) {
		
		return new ArrayList<>();
	}

	@Override
	public List<Match> getAll() {
		
		return new ArrayList<>();
	}
}
