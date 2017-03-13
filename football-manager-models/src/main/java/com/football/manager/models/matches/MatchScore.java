package com.football.manager.models.matches;

import com.football.manager.models.common.Score;

public class MatchScore {
	
	protected Score homeTeamScore;
	protected Score visitorTeamScore;
	
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
