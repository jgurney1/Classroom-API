package com.qa.persistence.domain;


import javax.persistence.*;

@Entity
public class Classroom {

	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Id
	private int roomId;
	private String trainer;
	
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
	
	
}
