package com.football.manager.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.football.manager.models.Classification;
import com.football.manager.models.Match;
import com.football.manager.models.MatchScore;
import com.football.manager.models.Score;
import com.football.manager.repository.interfaces.ClassificationRepository;
import com.football.manager.repository.interfaces.MatchRepository;
import com.football.manager.services.interfaces.MatchService;

@Service
public class MatchServiceImpl implements MatchService {

	private MatchRepository repository;
	private ClassificationRepository classificationRepository;
	
	private int matchId = 0;
	private Classification homeTeamClassification;
	private Classification visitorTeamClassification;

	public MatchServiceImpl(MatchRepository repository, 
			ClassificationRepository classificationRepository) {
		this.repository = repository;
		this.classificationRepository = classificationRepository;
	}

	@Override
	public Match save(MatchScore matchScore) {

		Match match = new Match(matchScore);
		
		matchId++;

		match.setId(matchId);
		
		repository.save(match);
		
		updateChampionshipClassification(match);
		
		return match;
	}

	@Override
	public Match getInfo(int matchId) {

		return repository.getInfo(matchId);
	}

	@Override
	public List<Match> getAllByTeam(int teamId) {

		return repository.getAllByTeam(teamId);
	}

	@Override
	public List<Match> getAll() {

		return repository.getAll();
	}

	private void updateChampionshipClassification(Match match) {
		
		Score homeScore = match.getHomeTeamScore();
		Score visitorScore = match.getVisitorTeamScore();
		
		homeTeamClassification = classificationRepository.getTeamClassification(homeScore.getTeamId());
		visitorTeamClassification = classificationRepository.getTeamClassification(visitorScore.getTeamId());
		
		if (!validateTeamsClassification(homeTeamClassification, visitorTeamClassification)) 
			return;
		
		updateGamesPlayed();
		
		updateStatus(homeScore.getGoals(), visitorScore.getGoals());
		
		setGoalsFor(homeScore.getGoals(), visitorScore.getGoals());
		
		setGoalsAgainst(visitorScore.getGoals(), homeScore.getGoals());
		
		classificationRepository.updateChampionshipClassification(homeTeamClassification);
		classificationRepository.updateChampionshipClassification(visitorTeamClassification);
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
