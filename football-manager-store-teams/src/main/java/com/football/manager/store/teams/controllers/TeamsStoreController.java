package com.football.manager.store.teams.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.football.manager.models.teams.Team;
import com.football.manager.store.teams.interfaces.TeamStore;
import com.football.manager.store.teams.requests.RequestMappingGetAll;
import com.football.manager.store.teams.requests.RequestMappingGetTeamName;

@RestController
public class TeamsStoreController {

	@Autowired
	private TeamStore store;
	
	@RequestMappingGetAll
	public ResponseEntity<List<Team>> getAll() {
		return new ResponseEntity<>(store.getAll(), HttpStatus.OK);
	}
	
	@RequestMappingGetTeamName
	public ResponseEntity<String> getTeamName(@PathVariable("teamId") int teamId){
		return new ResponseEntity<>(store.getTeamName(teamId), HttpStatus.OK);
	}
}
