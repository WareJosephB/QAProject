package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.business.service.PlayerService;

@Path("/player")
public class PlayerEndpoint  implements Pointable{

	@Inject
	private PlayerService service;
	
	public void setService(PlayerService service) {
		this.service = service;
	}

	@Path("/getAll")
	@GET
	@Produces({ "application/json" })
	public String getAll() {
		return service.getAll();
	}

	@Path("/add")
	@POST
	@Produces({ "application/json" })
	public String add(String player) {
		return service.add(player);
	}

	@Path("/delete/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String delete(int id) {
		return service.delete(id);
	}

	@Path("/get/{id}")
	@GET
	@Produces({ "application/json" })
	public String get(int id) {
		return service.get(id);
	}

}
