package com.football.manager.store.teams.inmemory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.football.manager.models.teams.Team;
import com.football.manager.store.teams.interfaces.TeamStore;

@Service
public class TeamStoreImpl implements TeamStore {

	private List<Team> teams;

	public TeamStoreImpl() {
		this.teams =  new ArrayList<>();
		
		teams.add(new Team(1, "CORINTHIANS"));
		teams.add(new Team(2, "PALMEIRAS"));
		teams.add(new Team(3, "SAO PAULO"));
	}

	@Override
	public List<Team> getAll() {
		return teams;
	}

	@Override
	public Team getById(int teamId) {
		return teams
				.stream()
				.filter(f -> f.getId() == teamId)
				.findFirst()
				.orElse(null);
	}
}
