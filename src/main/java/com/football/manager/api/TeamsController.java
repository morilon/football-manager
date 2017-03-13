package com.football.manager.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.football.manager.models.Team;
import com.football.manager.services.interfaces.TeamService;

@RestController
@RequestMapping("/teams")
public class TeamsController {

	private TeamService service;

	@Autowired
	public TeamsController(TeamService service) {
		this.service = service;
	}

	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<List<Team>> getAll() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}
}
