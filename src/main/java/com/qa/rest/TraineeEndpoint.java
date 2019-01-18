package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.TraineeService;

@Path("/trainee")
public class TraineeEndpoint {

	@Inject TraineeService service;
	
	@Path("/getalltrainees")
	@GET
	@Produces({"application/json"})
	public String getAllTrainees() {
		return service.getAllTrainees();
	}
	
	@Path("/addtoclassroom/{id}")
	@PUT
	@Produces({"application/json"})
	public String addToClassroom(@PathParam("id") int roomId, String trainee) {
		return service.addToClassroom(roomId, trainee);
	}
	
	@Path("/removefromclassroom/{id}")
	@PUT
	@Produces({"application/json"})
	public String removeFromClassRoom(@PathParam("id") int roomId, String trainee) {
		return service.removeFromClassroom(roomId, trainee);
	}
	
	@Path("/createtrainee")
	@POST
	@Produces({"application/json"})
	public String createTrainee(String trainee) {
		return service.createTrainee(trainee);
	}
}
