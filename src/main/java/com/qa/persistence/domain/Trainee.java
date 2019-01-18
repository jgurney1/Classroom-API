package com.qa.persistence.domain;

import javax.persistence.*;

@Entity
public class Trainee {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int traineeId;
	private String traineeName;
	
	@ManyToOne
	private int roomId;
	
	public Trainee() {
		//meant to be empty
	}
	
	public Trainee(String traineeName) {
		setTraineeName(traineeName);
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public int getTraineeId() {
		return traineeId;
	}

	public int getRoomId() {
		return roomId;
	}
	
	public void setRoomId(int id) {
		this.roomId = id;
	}
	
}
