package com.football.manager.models;

public class Score {
	
	private int teamId;
	private int goals;

	public Score() {
		// Default Constructor
	}
	
	public Score(int teamId, int goals) {
		this.teamId = teamId;
		this.goals = goals;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}	
}
