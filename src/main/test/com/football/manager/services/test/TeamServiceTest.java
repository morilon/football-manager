package com.football.manager.services.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.football.manager.models.Team;
import com.football.manager.repository.interfaces.TeamRepository;
import com.football.manager.services.TeamServiceImpl;

public class TeamServiceTest {

	private TeamServiceImpl service;
	private TeamRepository repository;
	
	private List<Team> teams;
	
	@Before
	public void Init(){
		
		teams = new ArrayList<>();
		
		teams.add(new Team(1, "MOCK TEAM"));
		
		repository = Mockito.mock(TeamRepository.class);
		Mockito.when(repository.getAll()).thenReturn(teams);
		
		service = new TeamServiceImpl(repository); 
	}
	
	@Test
	public void getAll_should_return_all_teams_from_list(){
		
		List<Team> expected = teams;
		List<Team> actual = service.getAll();
		
		assertEquals(expected, actual);
	}
}
