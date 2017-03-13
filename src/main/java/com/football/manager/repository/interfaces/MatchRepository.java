package com.football.manager.repository.interfaces;

import java.util.List;

import com.football.manager.models.Match;

public interface MatchRepository {
	
	Match save(Match match);
	Match getInfo(int matchId);
	List<Match> getAllByTeam(int teamId);
	List<Match> getAll();
}
