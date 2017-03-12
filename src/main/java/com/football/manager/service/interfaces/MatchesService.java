package com.football.manager.service.interfaces;

import java.util.List;
import com.football.manager.models.Match;

public interface MatchesService {
	void save(Match match);
	Match getInfo(int matchId);
	List<Match> getAllByTeam(int teamId);
	List<Match> getAll();
}
