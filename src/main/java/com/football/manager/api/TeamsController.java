package com.football.manager.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.football.manager.models.Team;
import com.football.manager.service.interfaces.TeamsService;

@RestController
@RequestMapping("/teams")
public class TeamsController {

	private TeamsService service;

	@Autowired
	public TeamsController(TeamsService service) {
		this.service = service;
	}

	@RequestMapping(value="", method=RequestMethod.GET)
	public List<Team> getAll() {
		return service.getAll();
	}
}
