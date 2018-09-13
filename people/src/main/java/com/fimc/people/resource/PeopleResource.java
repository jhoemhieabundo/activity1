package com.fimc.people.resource;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Path("/people")
public class PeopleResource {
	List<PeopleResponse> list = new ArrayList<PeopleResponse>();
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response keepPeople(PeopleRequest request) {
		
	if(StringUtils.isEmpty(request.getFirstName())||StringUtils.isEmpty(request.getLastName())||StringUtils.isEmpty(request.getBirthDate())) {
	return Response.status(Response.Status.BAD_REQUEST)
	             .entity(HttpServletResponse.SC_BAD_REQUEST).type( MediaType.TEXT_PLAIN).build();
	}else {
	PeopleResponse peopleResponse = new PeopleResponse();
	SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
	peopleResponse.setFname(String.format("%s",request.getFirstName()));
	peopleResponse.setLname(String.format("%s",request.getLastName()));
	peopleResponse.setBdate(formatter.format(request.getBirthDate()));
	list.add(peopleResponse);
	return Response.status(HttpServletResponse.SC_CREATED).entity(HttpServletResponse.SC_CREATED).build();
	}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response displayResult(PeopleRequest request) {
	return Response.ok().entity(list).build();
	}
	

}
