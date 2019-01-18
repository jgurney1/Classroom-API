package com.qa.persistence.domain;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Classroom {

	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Id
	private int roomId;
	private String trainer;
	private List<Trainee> trainees = new ArrayList<Trainee>();
	
	public Classroom() {
		//meant to be empty
	}
	
	public Classroom(String trainer) {
		setTrainer(trainer);
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public int getRoomId() {
		return roomId;
	}

	public List<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(List<Trainee> trainees) {
		this.trainees = trainees;
	}
	
	
}
