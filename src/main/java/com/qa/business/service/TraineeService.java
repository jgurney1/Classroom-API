package com.qa.business.service;

public interface TraineeService {
	String addToClassroom(int roomId, String trainee);
	String removeFromClassroom(int roomId, String trainee);
	String getAllTrainees();
	String createTrainee(String trainee);
}
