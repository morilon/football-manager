package com.football.manager.models.common;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ScoreTest {

	@Test
	public void Score_should_initialize_with_empty_values() {		
		Score score = new Score();
		
		assertThat(score.getTeamId(), is(equalTo(0)));
		assertThat(score.getGoals(), is(equalTo(0)));	
	}
	
	@Test
	public void Score_should_initialize_with_defined_values() {		
		Score score = new Score(1, 2);
		
		assertThat(score.getTeamId(), is(equalTo(1)));
		assertThat(score.getGoals(), is(equalTo(2)));	
	}
	
	@Test
	public void Score_should_set_values_when_set_is_called() {		
		Score score = new Score();
		
		score.setTeamId(1);
		score.setGoals(2);
		
		assertThat(score.getTeamId(), is(equalTo(1)));
		assertThat(score.getGoals(), is(equalTo(2)));	
	}
}
