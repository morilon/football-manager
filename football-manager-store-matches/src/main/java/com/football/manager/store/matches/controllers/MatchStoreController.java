package com.football.manager.store.matches.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.football.manager.models.matches.Match;
import com.football.manager.store.matches.interfaces.MatchStore;
import com.football.manager.store.matches.requests.RequestMappingDelete;
import com.football.manager.store.matches.requests.RequestMappingGetAll;
import com.football.manager.store.matches.requests.RequestMappingGetAllByTeam;
import com.football.manager.store.matches.requests.RequestMappingGetInfo;
import com.football.manager.store.matches.requests.RequestMappingSave;

@RestController
public class MatchStoreController {

	@Autowired
	private MatchStore store;

	@RequestMappingSave
	public ResponseEntity<Match> save(@RequestBody Match match){
		return new ResponseEntity<>(store.save(match), HttpStatus.OK);
	}

	@RequestMappingDelete
	public ResponseEntity<Void> delete(@PathVariable int matchId){
		store.delete(matchId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMappingGetInfo
	public ResponseEntity<Match> getInfo(@PathVariable int matchId) {
		return new ResponseEntity<>(store.getInfo(matchId), HttpStatus.OK);
	}

	@RequestMappingGetAllByTeam
	public ResponseEntity<List<Match>> getAllByTeam(@PathVariable int teamId) {
		return new ResponseEntity<>(store.getAllByTeam(teamId), HttpStatus.OK);
	}

	@RequestMappingGetAll
	public ResponseEntity<List<Match>> getAll() {
		return new ResponseEntity<>(store.getAll(), HttpStatus.OK);
	}
}
