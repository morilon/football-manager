package com.football.manager.service.matches.controllers;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.football.manager.models.common.Score;
import com.football.manager.models.matches.Match;
import com.football.manager.models.matches.MatchScore;
import com.football.manager.service.matches.interfaces.MatchService;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration
public class MatchServiceControllerTest {

	@Autowired
	private MockMvc mvc;

	@Mock
	private MatchService service;

	@InjectMocks
	private MatchServiceController controller;

	private List<Match> matches;
	private Gson gson;
	
	@Before
	public void SetUp() {
		gson = new Gson();
		MockitoAnnotations.initMocks(this);
		this.mvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void save_should_insert_new_match_on_memory() throws Exception {
		MatchScore matchScore = getMatchScore();		
		Match match = getMatch(matchScore);

		String jsonMatchScore = gson.toJson(matchScore);
		String jsonMatch = gson.toJson(match);

		when(this.service.save(any(Match.class))).thenReturn(match);

		mvc.perform(post("/matches")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonMatchScore))	
		.andExpect(status().isOk())		
		.andExpect(content().json(jsonMatch));
	}

	@Test
	public void save_return_bad_request_when_request_is_null() throws Exception {
		mvc.perform(post("/matches"))	
		.andExpect(status().isBadRequest())		
		.andExpect(content().string(""));
	}
	
	@Test
	public void save_return_bad_request_when_request_is_invalid() throws Exception {
		String match = gson.toJson(new MatchScore());
		
		mvc.perform(post("/matches")
				.contentType(MediaType.APPLICATION_JSON)
				.content(match))	
		.andExpect(status().isBadRequest())		
		.andExpect(content().string(""));
	}
	
	@Test
	public void delete_should_remove_a_match() throws Exception {
		mvc.perform(delete("/matches/1"))
		.andExpect(status().isOk())
		.andExpect(content().string(""));
	}

	@Test
	public void getById_should_return_a_single_match() throws Exception {
		Match match = getMatch();

		when(this.service.getById(1)).thenReturn(match);

		String jsonResult = gson.toJson(match);

		mvc.perform(get("/matches/1"))
		.andExpect(status().isOk())
		.andExpect(content().json(jsonResult));
	}

	@Test
	public void getById_should_return_null_when_matchId_is_invalid() throws Exception {
		when(this.service.getById(999)).thenReturn(null);

		mvc.perform(get("/matches/1"))
		.andExpect(status().isOk())
		.andExpect(content().string(""));
	}

	@Test
	public void getAllByTeam_should_return_all_matches_for_a_specific_team() throws Exception {
		List<Match> expectedMatches = new ArrayList<>();
		expectedMatches.add(new Match(1, new MatchScore(new Score(1, 3), new Score(2, 1))));

		String jsonResult = gson.toJson(expectedMatches);

		when(this.service.getAllByTeam(1)).thenReturn(expectedMatches);

		mvc.perform(get("/matches/team/1"))
		.andExpect(status().isOk())
		.andExpect(content().json(jsonResult));
	}

	@Test
	public void getAllByTeam_should_return_empty_when_teamId_is_invalid() throws Exception {

		when(this.service.getAllByTeam(999)).thenReturn(null);

		mvc.perform(get("/matches/team/999"))
		.andExpect(status().isOk())
		.andExpect(content().string(""));
	}

	@Test
	public void getAll_should_return_all_matches() throws Exception {
		List<Match> matches = getMatches();

		when(this.service.getAll()).thenReturn(matches);

		String jsonResult = gson.toJson(matches);
		
		mvc.perform(get("/matches"))
		.andExpect(status().isOk())
		.andExpect(content().json(jsonResult));
	}

	private Match getMatch() {
		return new Match(1, new MatchScore(new Score(1, 2), new Score(2, 0)));
	}

	private Match getMatch(MatchScore matchScore) {
		return new Match(1, matchScore);
	}

	private MatchScore getMatchScore() {
		return new MatchScore(new Score(1, 2), new Score(2, 0));
	}

	private List<Match> getMatches() {
		matches = new ArrayList<>();

		matches.add(new Match(1, new MatchScore(new Score(1, 3), new Score(2, 1))));
		matches.add(new Match(2, new MatchScore(new Score(2, 2), new Score(3, 2))));
		matches.add(new Match(3, new MatchScore(new Score(3, 1), new Score(2, 3))));

		return matches;
	}
	
}
