package com.football.manager.services.interfaces;

import java.util.List;

import com.football.manager.models.ChampionshipClassification;

@FunctionalInterface
public interface ClassificationService {
	List<ChampionshipClassification> getClassification();
}
