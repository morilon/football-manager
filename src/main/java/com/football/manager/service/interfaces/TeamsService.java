package com.football.manager.service.interfaces;

import java.util.List;
import com.football.manager.models.Team;

@FunctionalInterface
public interface TeamsService {
	List<Team> getAll();
}
