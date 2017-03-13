package com.football.manager.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.football.manager.models.Team;
import com.football.manager.repository.interfaces.TeamRepository;

@Service
public class InMemoryTeamRepository implements TeamRepository {

	private List<Team> teams;

	public InMemoryTeamRepository() {
		this.teams =  new ArrayList<>();
	}

	@Override
	public List<Team> getAll() {

		teams.add(new Team(1, "CORINTHIANS"));
		teams.add(new Team(2, "PALMEIRAS"));
		teams.add(new Team(3, "SAO PAULO"));

		return teams;
	}

	@Override
	public String getTeamName(int teamId) {
		Team team = teams
				.stream()
				.filter(f -> f.getId() == teamId)
				.findFirst()
				.orElse(null);
		
		return team.getName();
	}
}
