package com.football.manager.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.football.manager.models.Match;
import com.football.manager.models.MatchScore;
import com.football.manager.repository.interfaces.MatchRepository;
import com.football.manager.services.interfaces.MatchService;

@Service
public class MatchServiceImpl implements MatchService {

	private MatchRepository repository;

	public MatchServiceImpl(MatchRepository repository) {
		this.repository = repository;
	}

	@Override
	public Match save(MatchScore matchScore) {

		Match match = new Match(matchScore);
		
		return repository.save(match);
	}

	@Override
	public Match getInfo(int matchId) {

		return repository.getInfo(matchId);
	}

	@Override
	public List<Match> getAllByTeam(int teamId) {

		return repository.getAllByTeam(teamId);
	}

	@Override
	public List<Match> getAll() {

		return repository.getAll();
	}
}
