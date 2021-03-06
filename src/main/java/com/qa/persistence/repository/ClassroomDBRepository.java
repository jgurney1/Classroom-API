package com.qa.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;
import java.util.List;



@Transactional(SUPPORTS)
@Default
public class ClassroomDBRepository implements ClassroomRepository{

	@PersistenceContext(unitName="primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	public String getAllClassrooms() {
		Query query = manager.createQuery("SELECT a FROM Classroom a WHERE a.roomId > 0");
		@SuppressWarnings("unchecked")
		Collection<Classroom> rooms = (Collection<Classroom>) query.getResultList();
		return util.getJSONForObject(rooms);
	}

	
	@Transactional(REQUIRED)
	public String updateRoom(int id, String trainer) {
		Classroom foundRoom = findRoom(id);
		Classroom newRoom = util.getObjectForJSON(trainer, Classroom.class);
		if(foundRoom != null) {
			manager.remove(foundRoom);
			manager.persist(newRoom);
			return "{\"message\": \"Trainer Updated\"}";
		}
		return "{\"message\": \"Room not found\"}";
	}
	
	public Classroom findRoom(int id) {
		return manager.find(Classroom.class, id);
	}

	@SuppressWarnings("unchecked")
	@Transactional(REQUIRED)
	public String getFull(int roomID) {
		Query query = manager.createQuery("SELECT a FROM Trainee a WHERE a.roomId =" + roomID);
		Classroom populated = findRoom(roomID);
		populated.setTrainees(query.getResultList());
		
		return null;
	}

}
