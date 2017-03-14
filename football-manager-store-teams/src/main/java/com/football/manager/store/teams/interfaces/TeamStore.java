package com.football.manager.store.teams.interfaces;

import java.util.List;

import com.football.manager.models.teams.Team;

public interface TeamStore {
	List<Team> getAll();
	Team getById(int teamId);
}
