package com.football.manager.store.matches.interfaces;

import java.util.List;

import com.football.manager.models.matches.Match;

public interface MatchStore {
	
	Match save(Match match);
	void delete(int matchId);
	Match getInfo(int matchId);
	List<Match> getAllByTeam(int teamId);
	List<Match> getAll();
}
