package com.football.manager.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.football.manager.models.Match;
import com.football.manager.service.interfaces.MatchesService;

@RestController
@RequestMapping("/matches")
public class MatchesController {

	private MatchesService service;

	@Autowired
	public MatchesController(MatchesService service) {
		this.service = service;
	}

	@RequestMapping(value="", method=RequestMethod.POST)
	public void save(@RequestBody Match match){
		service.save(match);
	}
	
	@RequestMapping(value="/{matchId}/info", method=RequestMethod.GET)
	public Match getInfo(@PathVariable("matchId") int matchId){
		return service.getInfo(matchId);
	}
	
	@RequestMapping(value="/team/{teamId}", method=RequestMethod.GET)
	public List<Match> getAllByTeam(@PathVariable("teamId") int teamId){
		return service.getAllByTeam(teamId);
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public List<Match> getAll(){
		return service.getAll();
	}
}
