package com.football.manager.service.matches.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.football.manager.matches.requests.RequestMappingDelete;
import com.football.manager.matches.requests.RequestMappingGetAll;
import com.football.manager.matches.requests.RequestMappingGetAllByTeam;
import com.football.manager.matches.requests.RequestMappingGetById;
import com.football.manager.matches.requests.RequestMappingSave;
import com.football.manager.models.matches.Match;
import com.football.manager.models.matches.MatchScore;
import com.football.manager.service.matches.interfaces.MatchService;

@RestController
public class MatchServiceController {

	@Autowired
	private MatchService service;

	@RequestMappingSave
	public ResponseEntity<Match> save(@RequestBody MatchScore matchScore) {

		if (matchScore == null || !matchScore.isValid())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

		return ResponseEntity.ok(service.save(matchScore));
	}

	@RequestMappingDelete
	public ResponseEntity<Void> delete(@PathVariable int matchId) {
		service.delete(matchId);
		return ResponseEntity.ok(null);
	}

	@RequestMappingGetById
	public ResponseEntity<Match> getById(@PathVariable int matchId) {
		return ResponseEntity.ok(service.getById(matchId));
	}

	@RequestMappingGetAllByTeam
	public ResponseEntity<List<Match>> getAllByTeam(@PathVariable int teamId) {
		return ResponseEntity.ok(service.getAllByTeam(teamId));
	}

	@RequestMappingGetAll
	public ResponseEntity<List<Match>> getAll() { 
		return ResponseEntity.ok(service.getAll());
	}
}
