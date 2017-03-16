package com.football.manager.service.teams.core;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.football.manager.models.teams.Team;
import com.football.manager.service.teams.interfaces.TeamStoreClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamServiceImplTest {

	@Autowired
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
		
		List<Team> expected = new ArrayList<>();
		
		when(this.store.getAll()).thenReturn(expected);
		
		service = new TeamServiceImpl();
		
		List<Team> actual = service.getAll();
		
		assertEquals(expected, actual);
	}
}
