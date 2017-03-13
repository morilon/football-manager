package com.football.manager.models;

public class Match extends MatchScore {

	private int id;

	public Match() {
		// Default constructor
	}

	public Match(MatchScore matchScore) {
		homeTeamScore = matchScore.getHomeTeamScore();
		visitorTeamScore = matchScore.getVisitorTeamScore();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}