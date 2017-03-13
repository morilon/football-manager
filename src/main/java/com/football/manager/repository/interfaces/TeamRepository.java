package com.football.manager.repository.interfaces;

import java.util.List;

import com.football.manager.models.Team;

public interface TeamRepository {
	List<Team> getAll();
	String getTeamName(int teamId);
}
