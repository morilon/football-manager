package com.football.manager.service.matches.interfaces;

import java.util.List;

import com.football.manager.models.matches.Match;
import com.football.manager.models.matches.MatchScore;

public interface MatchService {
	Match save(MatchScore matchScore);
	void delete(int matchId);
	Match getById(int matchId);
	List<Match> getAllByTeam(int teamId);
	List<Match> getAll();
}
