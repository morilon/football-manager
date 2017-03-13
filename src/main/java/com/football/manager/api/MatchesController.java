package com.football.manager.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.football.manager.models.Match;
import com.football.manager.models.MatchScore;
import com.football.manager.services.interfaces.MatchService;

@RestController
@RequestMapping("/matches")
public class MatchesController {

	private MatchService service;

	@Autowired
	public MatchesController(MatchService service) {
		this.service = service;
	}

	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Match> save(@RequestBody MatchScore matchScore){
		
		service.save(matchScore);		
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value="/{matchId}/info", method=RequestMethod.GET)
	public ResponseEntity<Match> getInfo(@PathVariable("matchId") int matchId){
		
		return new ResponseEntity<>(service.getInfo(matchId), HttpStatus.OK);
	}

	@RequestMapping(value="/team/{teamId}", method=RequestMethod.GET)
	public ResponseEntity<List<Match>> getAllByTeam(@PathVariable("teamId") int teamId){
		
		return new ResponseEntity<>(service.getAllByTeam(teamId), HttpStatus.OK);
		
	}

	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<List<Match>> getAll(){
		
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
		
	}
}
