package com.football.manager.service.teams.interfaces;

import java.util.List;

import com.football.manager.models.teams.Team;

public interface TeamService {
	List<Team> getAll();
	Team getById(int teamId);
}
