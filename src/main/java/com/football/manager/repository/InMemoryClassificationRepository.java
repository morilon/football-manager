package com.football.manager.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.football.manager.models.ChampionshipClassification;
import com.football.manager.models.Classification;
import com.football.manager.models.Team;
import com.football.manager.repository.interfaces.ClassificationRepository;
import com.football.manager.repository.interfaces.TeamRepository;

@Service
public class InMemoryClassificationRepository implements ClassificationRepository {

	private TeamRepository teamRepository;
	private  List<Classification> classification;

	public InMemoryClassificationRepository(TeamRepository teamRepository) {

		this.teamRepository = teamRepository;
		this.classification = new ArrayList<>();

		classification.add(new Classification(1));
		classification.add(new Classification(2));
		classification.add(new Classification(3));
	}

	@Override
	public List<ChampionshipClassification> getChampionshipClassification() {
		
		List<Team> teams = teamRepository.getAll();
		
		return teams
				.stream()
				.map(t -> new ChampionshipClassification(getTeamClassification(t.getId()), t.getName()))
				.collect(Collectors.toList());				
	}

	@Override
	public Classification getTeamClassification(int teamId){
		return classification
				.stream()
				.filter(f -> f.getTeamId() == teamId)
				.findFirst()
				.orElse(new Classification(teamId));
	}

	@Override
	public void updateChampionshipClassification(Classification current) {
		
		int index = this.classification.indexOf(getTeamClassification(current.getTeamId()));
		
		classification.set(index, current);
	}
}
