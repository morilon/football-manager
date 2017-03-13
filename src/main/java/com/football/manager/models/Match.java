package com.football.manager.models;

public class Match {
	
	private int id;
	private Score homeTeamScore;
	private Score visitorTeamScore;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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