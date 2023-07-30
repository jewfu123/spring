package com.desafio.jax.ibm.webservice.dto;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.desafio.jax.ibm.webservice.model.Event;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class EventDTO {

	@JsonIgnore
	private long EVENT_TIME;
	private String id;
	private String CLIENT_ID;
	private String DETAILS_JSON;
	private String ERROR;
	private String IP_ADDRESS;
	private String REALM_ID;
	private String SESSION_ID;
	private String TYPE;
	private String USER_ID;
	
	public Event convertDTOToEntity() {
		return new ModelMapper().map(this, Event.class);
	}
}