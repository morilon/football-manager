package com.football.manager.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.football.manager.models.Team;
import com.football.manager.repository.interfaces.TeamRepository;

@Service
public class InMemoryTeamRepository implements TeamRepository {

	@Override
	public List<Team> getAll() {

		List<Team> result = new ArrayList<>(); 

		result.add(new Team(1, "CORINTHIANS"));
		result.add(new Team(2, "PALMEIRAS"));
		result.add(new Team(3, "SAO PAULO"));

		return result;
	}
}
