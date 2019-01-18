package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.ClassroomService;

@Path("/classroom")
public class ClassroomEndpoints {
	
	@Inject ClassroomService service;
	
	@Path("/getallclassrooms")
	@GET
	@Produces({"application/json"})
	public String getAllClassrooms() {
		return service.getAllClassrooms();
	}
	
	@Path("/updateroom/{id}")
	@PUT
	@Produces({"application/json"})
	public String updateAccount(@PathParam("id") int id, String trainer) {
		return service.updateRoom(id, trainer);
	}

}
