package com.football.manager.models.matches;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MatchTest {

	@Test
	public void Match_should_initialize_with_null_values() {
		Match match = new Match();
		
		assertThat(match.getId(), is(equalTo(0)));
		assertThat(match.getHomeTeamScore(), is(equalTo(null)));
		assertThat(match.getVisitorTeamScore(), is(equalTo(null)));
	}
	
	@Test
	public void Match_should_initialize_with_empty_values() {
		Match match = new Match(new MatchScore());
		
		assertThat(match.getId(), is(equalTo(0)));
		assertThat(match.getHomeTeamScore(), is(equalTo(null)));
		assertThat(match.getVisitorTeamScore(), is(equalTo(null)));
	}
	
	@Test
	public void Match_should_initialize_with_defined_values() {
		Match match = new Match(1, new MatchScore());
		
		assertThat(match.getId(), is(equalTo(1)));
		assertThat(match.getHomeTeamScore(), is(equalTo(null)));
		assertThat(match.getVisitorTeamScore(), is(equalTo(null)));
	}
	
	@Test
	public void Match_should_set_values_when_set_is_called() {
		Match match = new Match(new MatchScore());
		
		match.setId(1);
		
		assertThat(match.getId(), is(equalTo(1)));
		assertThat(match.getHomeTeamScore(), is(equalTo(null)));
		assertThat(match.getVisitorTeamScore(), is(equalTo(null)));
	}
}
