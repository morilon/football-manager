package com.football.manager.service.matches.core;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.football.manager.models.common.Score;
import com.football.manager.models.matches.Match;
import com.football.manager.models.matches.MatchScore;
import com.football.manager.service.matches.interfaces.MatchStoreClient;

public class MatchServiceImplTest {

	@InjectMocks
	private MatchServiceImpl service;
	
	@Mock
	private MatchStoreClient store;
	
	@Before
	public void SetUp() {
		service = new MatchServiceImpl();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void save_should_insert_a_new_match() {
		MatchScore matchScore = new MatchScore(new Score(1,2), new Score(2, 0));
		Match match = new Match(1, matchScore);
		
		when(this.store.save(match)).thenReturn(match);
		
		Match actual = service.save(match);
		
		assertEquals(match, actual);
	}
	
	@Test
	public void getById_should_return_match_when_id_is_valid() {
		MatchScore matchScore = new MatchScore(new Score(1,2), new Score(2, 0));
		Match match = new Match(1, matchScore);
		
		when(this.store.getById(1)).thenReturn(match);
		
		Match actual = service.getById(1);
		
		assertEquals(match, actual);
	}
	
	@Test
	public void getById_should_return_null_when_id_is_invalid() {
	
		when(this.store.getById(999)).thenReturn(null);
		
		Match actual = service.getById(1);
		
		assertEquals(actual, null);
	}
	
	@Test
	public void getAllByTeam_should_return_all_matches_for_a_specific_team() {
	
		List<Match> expected = new ArrayList<>();
		expected.add(new Match(1, new MatchScore(new Score(1, 1), new Score(2, 0))));
		expected.add(new Match(2, new MatchScore(new Score(2, 2), new Score(1, 1))));
		
		when(this.store.getAllByTeam(1)).thenReturn(expected);
		
		List<Match> actual = service.getAllByTeam(1);
		
		for(int i = 0; i < actual.size(); i++) {
			assertMatch(expected.get(i), actual.get(i));
		}
	}
	
	@Test
	public void getAll_should_return_all_matches() {
	
		List<Match> expected = getMockMatches();
		
		when(this.store.getAll()).thenReturn(expected);
		
		List<Match> actual = service.getAll();
		
		for(int i = 0; i < actual.size(); i++) {
			assertMatch(expected.get(i), actual.get(i));
		}
	}
	
	@Test
	public void delete_should_remove_a_match() {
		this.service.delete(1);
		
		verify(this.store, times(1)).delete(1);
	}
	
	private List<Match> getMockMatches() {
		List<Match> result = new ArrayList<>();
		
		result.add(new Match(1, new MatchScore(new Score(1,3), new Score(3, 1))));
		result.add(new Match(2, new MatchScore(new Score(2,2), new Score(2, 2))));
		result.add(new Match(3, new MatchScore(new Score(3,1), new Score(1, 3))));
		
		return result;
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
	
//	@Test
//	public void delete_should_remove_a_match_based_on_id() {
//				
//		service.delete(1);
//		
//		Mockito.verify(service.delete(1););
//	}
}
