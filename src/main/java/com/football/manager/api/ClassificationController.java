package com.football.manager.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.football.manager.models.Classification;
import com.football.manager.service.interfaces.ClassificationService;

@RestController
@RequestMapping("/classification")
public class ClassificationController {

	private ClassificationService service;
	
	@Autowired
	public ClassificationController(ClassificationService service) {
		this.service = service;
	}
	
	public Classification get(){
		return service.getClassification();
	}
}
