package com.qa.persistence.repository;

public interface TraineeRepository {

	String addToClassroom(int roomId, String trainee);
	String removeFromClassroom(int roomId, String trainee);
	String getAllTrainees();
	String createTrainee(String trainee);
	String deleteTrainee(int id);
	
}
