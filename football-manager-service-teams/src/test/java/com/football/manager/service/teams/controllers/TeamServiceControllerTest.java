package com.football.manager.service.teams.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.football.manager.models.teams.Team;
import com.football.manager.service.teams.interfaces.TeamService;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration
public class TeamServiceControllerTest {

	@Autowired
	private MockMvc mvc;

	@Mock
	private TeamService service;

	@InjectMocks
	private TeamServiceController controller;

	private Gson gson;
	
	@Before
	public void SetUp() {
		gson = new Gson();
		MockitoAnnotations.initMocks(this);
		this.mvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void getAll_should_return_all_matches() throws Exception {
		List<Team> teams = getMockTeams();
		
		when(this.service.getAll()).thenReturn(teams);
		
		String jsonResult = gson.toJson(teams);
		
		mvc.perform(get("/teams"))
		.andExpect(status().isOk())
		.andExpect(content().json(jsonResult));
	}
	
	@Test
	public void getById_should_return_a_single_team_when_id_is_valid() throws Exception {
		Team expected = new Team(1, "TEAM ONE");
		
		when(this.service.getById(1)).thenReturn(expected);
		
		String jsonResult = gson.toJson(expected);
		
		mvc.perform(get("/teams/1"))
		.andExpect(status().isOk())
		.andExpect(content().json(jsonResult));
	}
	
	private List<Team> getMockTeams() {

		List<Team> result = new ArrayList<>();
		
		result.add(new Team(1, "TEAM ONE"));
		result.add(new Team(2, "TEAM TWO"));
		result.add(new Team(3, "TEAM THREE"));
		
		return result;
	}
}
