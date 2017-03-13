package com.football.manager.repository.interfaces;

import java.util.List;

import com.football.manager.models.ChampionshipClassification;
import com.football.manager.models.Match;

public interface ClassificationRepository {
	
	List<ChampionshipClassification> getChampionshipClassification();
	
	Boolean updateChampionship(Match match);	
}
