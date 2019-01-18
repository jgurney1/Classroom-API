package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.ClassroomRepository;



public class ClassroomServiceImpl implements ClassroomService {

	@Inject
	private ClassroomRepository repo;
	
	public String getAllClassrooms() {
		return repo.getAllClassrooms();
	}

	public String updateRoom(int id, String trainer) {
		return repo.updateRoom(id, trainer);
	}

}
