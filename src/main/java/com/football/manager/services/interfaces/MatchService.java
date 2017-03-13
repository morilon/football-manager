package com.football.manager.services.interfaces;

import java.util.List;

import com.football.manager.models.Match;
import com.football.manager.models.MatchScore;

public interface MatchService {
	Match save(MatchScore matchScore);
	Match getInfo(int matchId);
	List<Match> getAllByTeam(int teamId);
	List<Match> getAll();
}
