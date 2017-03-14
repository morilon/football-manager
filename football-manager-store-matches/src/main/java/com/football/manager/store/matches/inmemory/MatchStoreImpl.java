package com.football.manager.store.matches.inmemory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.football.manager.models.matches.Match;
import com.football.manager.models.matches.MatchScore;
import com.football.manager.store.matches.interfaces.MatchStore;

@Service
public class MatchStoreImpl implements MatchStore {

	private List<Match> matches;
	private int matchId;

	public MatchStoreImpl() {
		matches = new ArrayList<>();
		matchId = 0;
	}

	@Override
	public Match save(MatchScore matchScore) {
		matchId++;

		Match match = new Match(matchScore);
		
		match.setId(matchId);

		matches.add(match);

		return match;
	}

	@Override
	public void delete(int matchId) {
		matches.remove(matches.indexOf(getById(matchId)));
	}

	@Override
	public Match getById(int matchId) {
		return matches
				.stream()
				.filter(f -> f.getId() == matchId)
				.findFirst()
				.orElse(null);
	}

	@Override
	public List<Match> getAllByTeam(int teamId) {
		return matches
				.stream()
				.filter(f -> f.getHomeTeamScore().getTeamId() == teamId ||
				f.getVisitorTeamScore().getTeamId() == teamId)
				.collect(Collectors.toList());			
	}

	@Override
	public List<Match> getAll() {
		return matches;
	}

}
