package com.football.manager.models;

public class Classification extends ClassificationStatus {

	private int teamId;

	public Classification(int teamId) {
		this.teamId = teamId;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

}
