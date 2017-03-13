package com.football.manager.repository.interfaces;

import java.util.List;

import com.football.manager.models.ChampionshipClassification;
import com.football.manager.models.Classification;

public interface ClassificationRepository {
	
	List<ChampionshipClassification> getChampionshipClassification();
	
	Classification getTeamClassification(int teamId);	
	
	void updateChampionshipClassification(Classification classification);
	
}
