package com.football.manager.store.teams.inmemory.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.football.manager.models.teams.Team;
import com.football.manager.store.teams.inmemory.TeamStoreImpl;

public class TeamStoreImplTest {

	private TeamStoreImpl store;
	private List<Team> teams;

	@Before
	public void SetUp() {
		store = new TeamStoreImpl();

		this.teams =  new ArrayList<>();

		teams.add(new Team(1, "CORINTHIANS"));
		teams.add(new Team(2, "PALMEIRAS"));
		teams.add(new Team(3, "SAO PAULO"));
	}

	@Test
	public void getAll_should_return_all_available_teams() {

		List<Team> expected = teams;

		List<Team> actual = store.getAll();

		assertThat(actual.size(), is(3));

		assertTeams(actual, expected);
	}
	
	@Test
	public void getTeamById_should_return_a_valid_team() {
		
		Team expected = new Team(1, "CORINTHIANS");
		
		Team actual = store.getById(1);
		
		assertThat(expected.getId(), is(equalTo(actual.getId())));
		assertThat(expected.getName(), is(equalTo(actual.getName())));
	}
	
	@Test
	public void getTeambyId_should_return_empty_when_teamId_is_invalid() {
				
		Team actual = store.getById(999);
		
		assertThat(actual, is(equalTo(null)));
	}
	
	private void assertTeams(List<Team> actual, List<Team> expected) {
		for(int i = 0; i < expected.size(); i++) {
			assertThat(actual.get(i).getId(), is(equalTo(expected.get(i).getId())));
			assertThat(actual.get(i).getName(), is(equalTo(expected.get(i).getName())));
		}		
	}
}

