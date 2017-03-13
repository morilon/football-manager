package com.football.manager.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.football.manager.models.Match;
import com.football.manager.repository.interfaces.ClassificationRepository;
import com.football.manager.repository.interfaces.MatchRepository;

@Service
public class InMemoryMatchRepository implements MatchRepository {

	private ClassificationRepository classificationRepository;
	private List<Match> matches;
	private int matchId = 0;

	public InMemoryMatchRepository(ClassificationRepository classificationRepository) {
		this.classificationRepository = classificationRepository;
		matches = new ArrayList<>();
	}

	@Override
	public Match save(Match match) {

		matchId++;

		match.setId(matchId);

		matches.add(match);
		
		classificationRepository.updateChampionship(match);
		
		return match;
	}

	@Override
	public Match getInfo(int matchId) {

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
