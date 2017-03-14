package com.football.manager.store.matches.controllers.tests;

import static org.mockito.Mockito.when;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.football.manager.models.common.Score;
import com.football.manager.models.matches.Match;
import com.football.manager.models.matches.MatchScore;
import com.football.manager.store.matches.controllers.MatchStoreController;
import com.football.manager.store.matches.interfaces.MatchStore;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration
public class MatchStoreControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Mock
	private MatchStore store;
	
	@InjectMocks
	private MatchStoreController controller;
	
	private List<Match> matches;
	private Gson gson;
	
	@Before
	public void SetUp() {
		gson = new Gson();
		matches = new ArrayList<>();
		MockitoAnnotations.initMocks(this);
		this.mvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void save_should_insert_new_match_on_memory() throws Exception {
		
		MatchScore matchScore = new MatchScore(new Score(1, 2), new Score(2, 0)); 
		Match match = new Match(1, matchScore);
		
		when(this.store.save(match)).thenReturn(match);
		
		mvc.perform(post("/matches"))
		.andExpect(status().isCreated())
		.andExpect(content().json(gson.toJson(match)));
	}
}
