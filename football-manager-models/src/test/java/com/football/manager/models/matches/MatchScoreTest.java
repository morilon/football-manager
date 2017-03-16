package com.football.manager.models.matches;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.football.manager.models.common.Score;

public class MatchScoreTest {
	@Test
	public void MatchScore_should_initialize_with_null_values() {		
		MatchScore score = new MatchScore();
		
		assertThat(score.getHomeTeamScore(), is(equalTo(null)));
		assertThat(score.getVisitorTeamScore(), is(equalTo(null)));
	}
	
	@Test
	public void MatchScore_should_initialize_with_empty_defined_values() {		
	
		MatchScore score = new MatchScore(new Score(), new Score());
		
		assertThat(score.getHomeTeamScore().getTeamId(), is(equalTo(0)));
		assertThat(score.getHomeTeamScore().getGoals(), is(equalTo(0)));
		
		assertThat(score.getVisitorTeamScore().getTeamId(), is(equalTo(0)));
		assertThat(score.getVisitorTeamScore().getGoals(), is(equalTo(0)));
	}
	
	@Test
	public void MatchScore_should_initialize_with_defined_values() {		
	
		MatchScore score = new MatchScore(new Score(1, 2), new Score(2, 1));
		
		assertThat(score.getHomeTeamScore().getTeamId(), is(equalTo(1)));
		assertThat(score.getHomeTeamScore().getGoals(), is(equalTo(2)));
		
		assertThat(score.getVisitorTeamScore().getTeamId(), is(equalTo(2)));
		assertThat(score.getVisitorTeamScore().getGoals(), is(equalTo(1)));
	}
	
	@Test
	public void MatchScore_should_set_values_when_set_is_called() {		
		MatchScore score = new MatchScore();
		
		score.setHomeTeamScore(new Score(1, 2));
		score.setVisitorTeamScore(new Score(2, 1));
		
		assertThat(score.getHomeTeamScore().getTeamId(), is(equalTo(1)));
		assertThat(score.getHomeTeamScore().getGoals(), is(equalTo(2)));
		
		assertThat(score.getVisitorTeamScore().getTeamId(), is(equalTo(2)));
		assertThat(score.getVisitorTeamScore().getGoals(), is(equalTo(1)));
	}
	
	@Test
	public void MatchScore_should_be_invalid_when_both_scores_are_null() {
		MatchScore score = new MatchScore();
		
		assertThat(score.isValid(), is(false));
	}
	
	@Test
	public void MatchScore_should_be_invalid_when_homeScore_is_null() {
		MatchScore score = new MatchScore(null, new Score());
		
		assertThat(score.isValid(), is(false));
	}
	
	@Test
	public void MatchScore_should_be_invalid_when_visitorScore_is_null() {
		MatchScore score = new MatchScore(new Score(), null);
		
		assertThat(score.isValid(), is(false));
	}
	
	@Test
	public void MatchScore_should_be_invalid_when_teamIds_are_invalid() {
		MatchScore score = new MatchScore(new Score(0,2), new Score(0,1));
		
		assertThat(score.isValid(), is(false));
	}
	
	@Test
	public void MatchScore_should_be_valid_when_scores_are_filled() {
		MatchScore score = new MatchScore(new Score(1,2), new Score(2,1));
		
		assertThat(score.isValid(), is(true));
	}
}
