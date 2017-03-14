package com.football.manager.models.matches;

public class Match extends MatchScore {

	private int id;

	public Match() {
		// Default constructor
	}

	public Match(int id, MatchScore matchScore) {
		this.id = id;
		homeTeamScore = matchScore.getHomeTeamScore();
		visitorTeamScore = matchScore.getVisitorTeamScore();
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