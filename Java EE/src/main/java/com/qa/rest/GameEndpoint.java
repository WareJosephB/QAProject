package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.business.service.GameService;

@Path("/game")
public class GameEndpoint implements Pointable {

	@Inject
	private GameService service;

	public void setService(GameService service) {
		this.service = service;
	}

	@Override
	@Path("/getAll")
	@GET
	@Produces({ "application/json" })
	public String getAll() {
		return service.getAll();
	}

	@Override
	@Path("/add")
	@POST
	@Produces({ "application/json" })
	public String add(String game) {
		return service.add(game);
	}

	@Override
	@Path("/delete/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String delete(@PathParam("id") Long id) {
		return service.delete(id);
	}

	@Override
	@Path("/get/{id}")
	@GET
	@Produces({ "application/json" })
	public String get(@PathParam("id") Long id) {
		return service.get(id);
	}

	@Override
	@Path("/update/{id}")
	@PUT
	@Produces({ "application/json" })
	public String update(@PathParam("id") Long id, String entity) {
		return service.update(id, entity);
	}
	
	@Path("/match")
	@POST
	@Produces({ "application/json" })
	public String update(String simpleGame) {
		return service.update(simpleGame);
	}
	
}
