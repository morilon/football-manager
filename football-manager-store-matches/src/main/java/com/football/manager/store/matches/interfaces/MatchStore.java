package com.football.manager.store.matches.interfaces;

import java.util.List;

import com.football.manager.models.matches.Match;
import com.football.manager.models.matches.MatchScore;

public interface MatchStore {

	Match save(MatchScore match);
	void delete(int matchId);
	Match getById(int matchId);
	List<Match> getAllByTeam(int teamId);
	List<Match> getAll();
}
