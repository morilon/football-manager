package com.football.manager.repository.interfaces;

import java.util.List;

import com.football.manager.models.Team;

@FunctionalInterface
public interface TeamRepository {
	List<Team> getAll();
}
