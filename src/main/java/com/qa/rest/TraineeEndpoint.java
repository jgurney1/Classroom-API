package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
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
	
	@Path("/removefromclassroom")
	@PUT
	@Produces({"application/json"})
	public String removeFromClassRoom(int roomId, String trainee) {
		return service.removeFromClassroom(roomId, trainee);
	}
}