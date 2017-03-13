package com.football.manager.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.football.manager.models.ChampionshipClassification;
import com.football.manager.repository.interfaces.ClassificationRepository;
import com.football.manager.services.interfaces.ClassificationService;

@Service
public class ClassificationServiceImpl implements ClassificationService  {

	private ClassificationRepository repository;

	public ClassificationServiceImpl(ClassificationRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<ChampionshipClassification> getClassification() {
		return repository.getChampionshipClassification();
	}

}
