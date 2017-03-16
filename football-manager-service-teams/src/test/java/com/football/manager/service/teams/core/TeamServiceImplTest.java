package com.football.manager.service.teams.core;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.football.manager.models.teams.Team;
import com.football.manager.service.teams.interfaces.TeamStoreClient;

public class TeamServiceImplTest {

	@InjectMocks
	private TeamServiceImpl service;
	
	@Mock
	private TeamStoreClient store;
	
	@Before
	public void SetUp() {
		service = new TeamServiceImpl();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAll_should_return_all_teams() {
		
		List<Team> expected = getMockTeams();
		
		when(this.store.getAll()).thenReturn(expected);
		
		List<Team> actual = service.getAll();
		
		assertEquals(expected, actual);
	}

	@Test
	public void getTemById_should_return_a_single_team_when_valid_id_is_provided() {
		
		Team expected = new Team(1, "TEAM ONE");
		
		when(this.store.getById(1)).thenReturn(expected);
		
		Team actual = service.getById(1);
		
		assertEquals(expected, actual);		
	}
	
	private List<Team> getMockTeams() {

		List<Team> result = new ArrayList<>();
		
		result.add(new Team(1, "TEAM ONE"));
		result.add(new Team(2, "TEAM TWO"));
		result.add(new Team(3, "TEAM THREE"));
		
		return result;
	}
}
