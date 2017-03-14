package com.football.manager.service.teams.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.football.manager.models.teams.Team;
import com.football.manager.service.teams.interfaces.TeamService;
import com.football.manager.teams.requests.RequestMappingGetAll;
import com.football.manager.teams.requests.RequestMappingGetById;

@RestController
public class TeamServiceController {

	@Autowired
	private TeamService service;
	
	@RequestMappingGetAll
	public ResponseEntity<List<Team>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}
	
	@RequestMappingGetById
	public ResponseEntity<Team> getTeamName(@PathVariable int teamId) {
		return ResponseEntity.ok(service.getById(teamId));
	}
	
}
