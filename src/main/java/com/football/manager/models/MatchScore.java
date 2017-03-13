package com.football.manager.models;

public class MatchScore {
	
	private Score homeTeamScore;
	private Score visitorTeamScore;
	
	public MatchScore() {
		// Default Constructor
	}
	
	public MatchScore(Score homeTeamScore, Score visitorTeamScore) {
		this.homeTeamScore = homeTeamScore;
		this.visitorTeamScore = visitorTeamScore;
	}
	
	public Score getHomeTeamScore() {
		return homeTeamScore;
	}
	public void setHomeTeamScore(Score homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}
	public Score getVisitorTeamScore() {
		return visitorTeamScore;
	}
	public void setVisitorTeamScore(Score visitorTeamScore) {
		this.visitorTeamScore = visitorTeamScore;
	}
}