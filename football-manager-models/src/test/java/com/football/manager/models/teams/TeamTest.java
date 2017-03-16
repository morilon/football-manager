package com.football.manager.models.teams;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TeamTest {

	@Test
	public void Team_should_initialize_with_empty_values() {
		
		Team team = new Team();
		
		assertThat(team.getId(), is(equalTo(0)));
		assertThat(team.getName(), is(equalTo(null)));
	}
	
	@Test
	public void Team_should_initialize_with_defined_values() {
		
		Team team = new Team(1, "NAME");
		
		assertThat(team.getId(), is(equalTo(1)));
		assertThat(team.getName(), is(equalTo("NAME")));
	}
	
	@Test
	public void Team_should_set_values_when_set_is_called() {
		
		Team team = new Team();
		
		team.setId(1);
		team.setName("NAME");
		
		assertThat(team.getId(), is(equalTo(1)));
		assertThat(team.getName(), is(equalTo("NAME")));
	}
}
