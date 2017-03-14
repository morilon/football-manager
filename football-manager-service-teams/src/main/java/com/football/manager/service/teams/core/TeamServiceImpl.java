package com.football.manager.service.teams.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.manager.models.teams.Team;
import com.football.manager.service.teams.interfaces.TeamService;
import com.football.manager.service.teams.interfaces.TeamStoreClient;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamStoreClient storeClient;
	
	@Override
	public List<Team> getAll() {
		return storeClient.getAll();
	}

	@Override
	public Team getById(int teamId) {
		return storeClient.getById(teamId);
	}

}
