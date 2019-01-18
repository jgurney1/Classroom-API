package com.qa.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

@Transactional(SUPPORTS)
@Default
public class TraineeDBRepository implements TraineeRepository{

	@PersistenceContext(unitName="primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	@Transactional(REQUIRED)
	public String addToClassroom(int roomId, String trainee) {
		Trainee toAdd = util.getObjectForJSON(trainee, Trainee.class);
		toAdd.setRoomId(roomId);
		manager.persist(toAdd);
		return "{\"message\": \"Classroom Updated\"}";
	}

	@SuppressWarnings("null")
	@Transactional(REQUIRED)
	public String removeFromClassroom(int roomId, String trainee) {
		Trainee toRemove = util.getObjectForJSON(trainee, Trainee.class);
		Trainee newRoomId = util.getObjectForJSON(trainee, Trainee.class);
		newRoomId.setRoomId(999);
		if(toRemove != null) {
			manager.remove(toRemove);
			manager.persist(newRoomId);
			return "{\"message\": \"Trainee Removed\"}";
		}
		return "{\"message\": \"Trainee not found\"}";
	}

	public String getAllTrainees() {
		Query query = manager.createQuery("SELECT a FROM Trainee a");
		@SuppressWarnings("unchecked")
		Collection<Trainee> trainees = (Collection<Trainee>) query.getResultList();
		return util.getJSONForObject(trainees);
	}

}
