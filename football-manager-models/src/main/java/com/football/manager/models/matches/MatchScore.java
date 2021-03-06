package com.football.manager.models.matches;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	
	@JsonIgnore
	public Boolean isValid() {
	
		return this.homeTeamScore != null &&
				this.visitorTeamScore != null &&
				this.getHomeTeamScore().getTeamId() > 0 &&
				this.getVisitorTeamScore().getTeamId() > 0;
	}
}
