package com.football.manager.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.football.manager.models.ChampionshipClassification;
import com.football.manager.models.Classification;
import com.football.manager.models.Match;
import com.football.manager.models.Score;
import com.football.manager.repository.interfaces.ClassificationRepository;
import com.football.manager.repository.interfaces.TeamRepository;

@Service
public class InMemoryClassificationRepository implements ClassificationRepository {

	private TeamRepository teamRepository;
	private  List<Classification> classification;
	private Classification homeTeamClassification;
	private Classification visitorTeamClassification;

	public InMemoryClassificationRepository(TeamRepository teamRepository) {

		this.teamRepository = teamRepository;
		this.classification = new ArrayList<>();

		classification.add(new Classification(1));
		classification.add(new Classification(2));
		classification.add(new Classification(3));
	}

	@Override
	public List<ChampionshipClassification> getChampionshipClassification() {
		
		return classification
				.stream()
				.map(c -> new ChampionshipClassification(c, teamRepository.getTeamName(c.getTeamId())))
				.collect(Collectors.toList());				
	}

	@Override
	public Boolean updateChampionship(Match match) {

		Score homeScore = match.getHomeTeamScore();
		Score visitorScore = match.getVisitorTeamScore();

		homeTeamClassification = setHomeTeamClassification(homeScore.getTeamId());
		visitorTeamClassification = setVisitorTeamClassification(visitorScore.getTeamId());

		int homeIndex = classification.indexOf(homeTeamClassification);
		int visitorIndex = classification.indexOf(visitorTeamClassification);
		
		if (!validateTeamsClassification(homeTeamClassification, visitorTeamClassification)) 
			return false;

		updateGamesPlayed();
		
		updateStatus(homeScore.getGoals(), visitorScore.getGoals());
		
		setGoalsFor(homeScore.getGoals(), visitorScore.getGoals());
		
		setGoalsAgainst(visitorScore.getGoals(), homeScore.getGoals());
		
		classification.set(homeIndex, homeTeamClassification);
		classification.set(visitorIndex, visitorTeamClassification);
		
		return true;
	}

	private Classification setHomeTeamClassification(int teamId) {
		return classification
				.stream()
				.filter(f -> f.getTeamId() == teamId)
				.findFirst()
				.orElse(null);
	}

	private Classification setVisitorTeamClassification(int teamId) {
		return classification
				.stream()
				.filter(f -> f.getTeamId() == teamId)
				.findFirst()
				.orElse(null);
	}

	private Boolean validateTeamsClassification(Classification homeTeam, Classification visitorTeam) {

		return homeTeam != null && visitorTeam != null;
	}

	private void updateStatus(int homeGoals, int visitorGoals) {
		
		if (homeGoals == visitorGoals)
		{
			setDraws(homeTeamClassification);
			setDraws(visitorTeamClassification);
			
			setPoints(homeTeamClassification, 1);
			setPoints(visitorTeamClassification, 1);
		}
		else if (homeGoals > visitorGoals)
		{
			setWins(homeTeamClassification);
			setLosses(visitorTeamClassification);
			
			setPoints(homeTeamClassification, 3);
		}
		else
		{
			setWins(visitorTeamClassification);
			setLosses(homeTeamClassification);
			
			setPoints(visitorTeamClassification, 3);
		}
	}
	
	private void setGoalsFor(int homeGoals, int visitorGoals) {
		homeTeamClassification.setGoalsFor(homeTeamClassification.getGoalsFor() + homeGoals);
		visitorTeamClassification.setGoalsFor(visitorTeamClassification.getGoalsFor() + visitorGoals);
	}
	
	private void setGoalsAgainst(int homeGoals, int visitorGoals) {
		homeTeamClassification.setGoalsAgainst(homeTeamClassification.getGoalsAgainst() + homeGoals);
		visitorTeamClassification.setGoalsAgainst(visitorTeamClassification.getGoalsAgainst() + visitorGoals);
	}
	
	private void updateGamesPlayed() {
		
		homeTeamClassification.setGamesPlayed(homeTeamClassification.getGamesPlayed() + 1);
		visitorTeamClassification.setGamesPlayed(visitorTeamClassification.getGamesPlayed() + 1);
	}
	
	private void setWins(Classification current) {
		current.setWins(current.getWins() + 1);
	}
	
	private void setLosses(Classification current) {
		current.setLosses(current.getLosses() + 1);
	}
	
	private void setDraws(Classification current) {
		current.setDraws(current.getDraws() + 1);
	}
	
	private void setPoints(Classification current, int points) {
		current.setPoints(current.getPoints() + points);
	}
}
