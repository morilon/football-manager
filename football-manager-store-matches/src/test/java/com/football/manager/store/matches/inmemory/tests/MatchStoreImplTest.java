package com.football.manager.store.matches.inmemory.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.football.manager.models.common.Score;
import com.football.manager.models.matches.Match;
import com.football.manager.models.matches.MatchScore;
import com.football.manager.store.matches.inmemory.MatchStoreImpl;

public class MatchStoreImplTest {

	private MatchStoreImpl store;

	@Before
	public void SetUp() {
		store = new MatchStoreImpl();
	}

	@Test
	public void save_should_successfully_include_a_new_match() {

		Match expected = getMatch(1);

		Match actual = store.save(getMatchScore());

		assertMatch(expected, actual);
	}

	@Test
	public void save_should_include_a_new_match_in_memory() {

		Match expected = getMatch(1);

		store.save(getMatchScore());

		List<Match> matches = store.getAll();

		assertThat(matches.size(), is(1));
		assertMatch(expected, matches.get(0));
	}

	@Test
	public void delete_should_remove_a_match_from_memory() {
		store.save(getMatchScore());

		store.delete(1);

		List<Match> matches = store.getAll();

		assertThat(matches.size(), is(0));
	}

	@Test
	public void getById_should_return_a_single_match_by_Id() {
		setMatches();

		Match expected = new Match();
		expected.setId(3);
		expected.setHomeTeamScore(new Score(3, 3));
		expected.setVisitorTeamScore(new Score(2, 2));

		Match actual = store.getById(3);

		assertMatch(expected, actual);
	}

	@Test
	public void getById_should_return_null_when_matchId_is_invalid() {
		setMatches();

		Match actual = store.getById(999);

		assertThat(actual, is(equalTo(null)));
	}

	@Test
	public void getAllByTeam_should_return_all_matches_for_a_specific_team() {
		setMatches();	

		Match expected = new Match(new MatchScore(new Score(3, 3), new Score(2, 2)));
		expected.setId(3);

		List<Match> matches = store.getAllByTeam(3);

		assertThat(matches.size(), is(equalTo(1)));
		assertMatch(expected, matches.get(0));
	}

	@Test
	public void getAllByTeam_should_return_empty_when_teamId_is_invalid() {
		setMatches();	

		List<Match> matches = store.getAllByTeam(999);

		assertThat(matches.size(), is(equalTo(0)));
	}

	public void getAll_should_return_all_matches() {
		setMatches();

		List<Match> expected = new ArrayList<>();
		expected.add(new Match(1, new MatchScore(new Score(1, 1), new Score(2, 0))));
		expected.add(new Match(2, new MatchScore(new Score(2, 2), new Score(1, 1))));
		expected.add(new Match(3, new MatchScore(new Score(3, 3), new Score(2, 2))));

		List<Match> actual = store.getAll();

		assertThat(expected.size(), is(equalTo(actual.size())));

		for(int i = 0; i < actual.size(); i++) {
			assertMatch(expected.get(i), actual.get(i));
		}
	}

	private void assertMatch(Match expected, Match actual) {
		assertThat(expected.getId(), is(equalTo(actual.getId())));		
		assertScore(expected.getHomeTeamScore(), actual.getHomeTeamScore());
		assertScore(expected.getVisitorTeamScore(), actual.getVisitorTeamScore());
	}

	private void assertScore(Score expected, Score actual) {
		assertThat(expected.getTeamId(), is(equalTo(actual.getTeamId())));
		assertThat(expected.getGoals(), is(equalTo(actual.getGoals())));
	}

	private Match getMatch(int matchId) {

		Match match = new Match();

		if (matchId > 0) match.setId(matchId);

		match.setHomeTeamScore(new Score(1, 1));
		match.setVisitorTeamScore(new Score(2, 0));

		return match;
	}

	private MatchScore getMatchScore() {
		return new MatchScore(new Score(1, 1), new Score(2, 0));
	}

	private void setMatches() {

		store.save(new MatchScore(new Score(1, 1), new Score(2, 0)));
		store.save(new MatchScore(new Score(2, 2), new Score(1, 1)));
		store.save(new MatchScore(new Score(3, 3), new Score(2, 2)));
	}
}
