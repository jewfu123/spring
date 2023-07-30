package com.desafio.jax.ibm.webservice.service;

import java.util.List;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.desafio.jax.ibm.webservice.dao.EventDAO;
import com.desafio.jax.ibm.webservice.dto.EventDTO;
import com.desafio.jax.ibm.webservice.model.Event;

public class EventService {

	EventDAO dao = new EventDAO();
	
	/*
	 * M�todo de aplica��o das regras de neg�cio e tratamento de exce��es na a��o de inserir uma pessoa. 
	 * */
//	public EventDTO savePessoa(EventDTO event) {
//		
//		if (event.getNome() == null || pessoa.getNome().isEmpty()) {
//			throw new ClientErrorException(Response.status(Status.BAD_REQUEST).entity("Nome n�o informado!").build());
//		}
//		if (pessoa.getCpf() == null || pessoa.getCpf().isEmpty()) {
//			throw new ClientErrorException(Response.status(Status.BAD_REQUEST).entity("CPF n�o informado!").build());
//		}
//		Event retorno = dao.save(pessoa.convertDTOToEntity()); 
//		return retorno.convertEntityToDTO();
//	}
	
	/*
	 * M�todo de aplica��o das regras de neg�cio e tratamento de exce��es na a��o de buscar uma pessoa. 
	 * */
//	public EventDTO findByUserid(String search){
//		return dao.findByUserid(search).stream().findFirst().map(achou -> achou.convertEntityToDTO())
//				.orElseThrow(() -> new NotFoundException(
//						Response.status(Status.NOT_FOUND).entity("Pessoa n�o encontrada!").build()));
//	}
	
	public List<Event> findAll() {
		return dao.findAll();
	}
	
}
