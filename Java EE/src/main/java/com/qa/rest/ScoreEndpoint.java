package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.business.service.ScoreService;

@Path("/score")
public class ScoreEndpoint implements Pointable {

	@Inject
	private ScoreService service;

	public void setService(ScoreService service) {
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
	public String add(String score) {
		return service.add(score);
	}

	@Path("/delete/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String delete(@PathParam("id") Long id) {
		return service.delete(id);
	}

	@Path("/get/{id}")
	@GET
	@Produces({ "application/json" })
	public String get(@PathParam("id") Long id) {
		return service.get(id);
	}

}
