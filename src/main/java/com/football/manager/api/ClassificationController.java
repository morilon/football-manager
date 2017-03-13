package com.football.manager.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.football.manager.models.ChampionshipClassification;
import com.football.manager.services.interfaces.ClassificationService;

@RestController
@RequestMapping("/classification")
public class ClassificationController {

	private ClassificationService service;

	@Autowired
	public ClassificationController(ClassificationService service) {
		this.service = service;
	}

	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<List<ChampionshipClassification>> get(){
		return new ResponseEntity<>(service.getClassification(), HttpStatus.OK);
	}
}
