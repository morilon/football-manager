package com.football.manager.services.interfaces;

import java.util.List;
import com.football.manager.models.Team;

@FunctionalInterface
public interface TeamService {
	List<Team> getAll();
}
