package com.football.manager.store.matches.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.football.manager.matches.requests.RequestMappingDelete;
import com.football.manager.matches.requests.RequestMappingGetAll;
import com.football.manager.matches.requests.RequestMappingGetAllByTeam;
import com.football.manager.matches.requests.RequestMappingGetById;
import com.football.manager.matches.requests.RequestMappingSave;
import com.football.manager.models.matches.Match;
import com.football.manager.models.matches.MatchScore;
import com.football.manager.store.matches.interfaces.MatchStore;

@RestController
public class MatchStoreController {

	@Autowired
	private MatchStore store;

	@RequestMappingSave
	public ResponseEntity<Match> save(@RequestBody MatchScore matchScore){

		if (matchScore == null || !matchScore.isValid())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		
		return ResponseEntity.ok(store.save(matchScore));
	}

	@RequestMappingDelete
	public ResponseEntity<Void> delete(@PathVariable int matchId){
		store.delete(matchId);
		return ResponseEntity.ok(null);
	}

	@RequestMappingGetById
	public ResponseEntity<Match> getById(@PathVariable int matchId) {
		return ResponseEntity.ok(store.getById(matchId));
	}

	@RequestMappingGetAllByTeam
	public ResponseEntity<List<Match>> getAllByTeam(@PathVariable int teamId) {
		return ResponseEntity.ok(store.getAllByTeam(teamId));
	}

	@RequestMappingGetAll
	public ResponseEntity<List<Match>> getAll() {
		return ResponseEntity.ok(store.getAll());
	}
}
