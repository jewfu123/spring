package com.desafio.jax.ibm.webservice.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.desafio.jax.ibm.webservice.dto.EventDTO;
import com.desafio.jax.ibm.webservice.model.Event;
import com.desafio.jax.ibm.webservice.service.EventService;

@Path("/events")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class EventResource {

	private EventService service = new EventService();

	/*
	 * Endpoint respons�vel por receber requisi��es para inserir uma pessoa.
	 * */
//	@POST
//	public Response save(PessoaDTO pessoa) {
//		pessoa = service.savePessoa(pessoa);
//		return Response.status(Status.CREATED)
//				.entity(pessoa)
//				.build();
//	}
	
	
	/*
	 * Endpoint respons�vel por receber requisi��es para buscar uma pessoa.
	 * */
//	@GET
//	@Path("{search}")
//	public Response find(@PathParam("search") String search) {
//		PessoaDTO pessoa = service.findByCpfOrName(search);
//		return Response.status(Status.OK)
//				.entity(pessoa)
//				.build();
//	}
	
	@GET
	@Path("/all")
	public Response findAll() {
		List<Event> events = service.findAll();
		return Response.status(Status.OK)
				.entity(events)
				.build();
	}
}
