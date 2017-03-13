package com.football.manager.models;

public class ChampionshipClassification extends ClassificationStatus {

	private String teamName;

	public ChampionshipClassification() {
		// Default constructor
	}


	public ChampionshipClassification(Classification classification, String teamName) {
		this.teamName = teamName;
		this.gamesPlayed = classification.getGamesPlayed();
		this.wins = classification.getWins();
		this.draws = classification.getDraws();
		this.losses = classification.getLosses();
		this.goalsFor = classification.getGoalsFor();
		this.goalsAgainst = classification.getGoalsAgainst();
		this.points = classification.getPoints();
	}

	public int getGoalDifference() {
		return this.goalsFor - this.goalsAgainst;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
}
