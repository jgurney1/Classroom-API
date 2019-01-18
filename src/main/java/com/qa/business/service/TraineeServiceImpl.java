package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.TraineeRepository;

public class TraineeServiceImpl implements TraineeService{

	@Inject
	private TraineeRepository repo;
	
	public String addToClassroom(int roomId, String trainee) {
		return repo.addToClassroom(roomId, trainee);
	}

	public String removeFromClassroom(int roomId, String trainee) {
		return repo.removeFromClassroom(roomId, trainee);
	}

	public String getAllTrainees() {
		return repo.getAllTrainees();
	}

}
