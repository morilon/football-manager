package com.football.manager.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.football.manager.models.Team;
import com.football.manager.service.interfaces.TeamsService;

@Service
public class TeamsServiceImpl implements TeamsService {

	@Override
	public List<Team> getAll() {
		
		List<Team> result = new ArrayList<>(); 
		
		result.add(new Team(1, "CORINTHIANS"));
		result.add(new Team(2, "PALMEIRAS"));
		result.add(new Team(3, "SAO PAULO"));
		
		return result;
	}

}
