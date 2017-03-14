package com.football.manager.store.teams.controller.tests;

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
import com.football.manager.store.teams.controllers.TeamStoreController;
import com.football.manager.store.teams.interfaces.TeamStore;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration
public class TeamStoreControllerTest {

	@Autowired
	private MockMvc mvc;

	@Mock
	private TeamStore store;

	@InjectMocks
	private TeamStoreController controller;

	private List<Team> teams;
	private Gson gson;

	@Before
	public void SetUp() {
		gson = new Gson();
		teams = getMockTeams();
		MockitoAnnotations.initMocks(this);
		this.mvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void getAll_should_return_a_valid_list() throws Exception {

		String expected = gson.toJson(teams);

		when(this.store.getAll()).thenReturn(teams);

		mvc.perform(get("/teams"))
		.andExpect(status().isOk())
		.andExpect(content().json(expected));
	}

	@Test
	public void getById_should_return_a_specific_team() throws Exception {

		Team expected = new Team(1, "NEW TEAM");

		when(this.store.getById(1)).thenReturn(expected);

		mvc.perform(get("/teams/1"))
		.andExpect(status().isOk())
		.andExpect(content().json(gson.toJson(expected)));
	}

	@Test
	public void getById_should_return_an_empty_string_when_teamId_doesnt_exist() throws Exception {

		when(this.store.getById(999)).thenReturn(null);

		mvc.perform(get("/teams/999"))
		.andExpect(status().isOk())
		.andExpect(content().string(""));
	}

	private List<Team> getMockTeams() {
		teams = new ArrayList<>();

		teams.add(new Team(1, "CORINTHIANS"));
		teams.add(new Team(2, "PALMEIRAS"));
		teams.add(new Team(3, "SAO PAULO"));

		return teams;
	}
}
