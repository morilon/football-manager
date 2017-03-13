package com.football.manager.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.football.manager.models.Team;
import com.football.manager.repository.interfaces.TeamRepository;
import com.football.manager.services.interfaces.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

	private TeamRepository repository;

	public TeamServiceImpl(TeamRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Team> getAll() {
		return repository.getAll();
	}

}
