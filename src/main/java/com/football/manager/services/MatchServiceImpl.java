package com.football.manager.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.football.manager.models.Match;
import com.football.manager.models.MatchScore;
import com.football.manager.services.interfaces.MatchService;

@Service
public class MatchServiceImpl implements MatchService {

	@Override
	public Match save(MatchScore match) {

		return new Match();
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
