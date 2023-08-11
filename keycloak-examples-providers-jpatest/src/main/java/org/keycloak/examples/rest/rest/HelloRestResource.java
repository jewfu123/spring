package org.keycloak.examples.rest.rest;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.keycloak.examples.rest.EventRepresentation;
import org.keycloak.examples.rest.EventUserRepresentation;
import org.keycloak.examples.rest.spi.MyService;
import org.keycloak.models.KeycloakSession;

public class HelloRestResource {
	private final KeycloakSession session;
	
	public HelloRestResource(KeycloakSession session) {
		System.out.println("------ HelloRestResource be created ==== ---> get session:" + session);
		this.session = session;
	}
	
	@GET
    @Path("/listall")
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public List<EventUserRepresentation> getCompanies() {
		System.out.println("------ HelloResource ============ ---> getCompanies() get session:" + session);
        return session.getProvider(MyService.class).listEvents();
    }
	
	@GET
    @NoCache
    @Path("/list/{uid}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EventRepresentation> getEventsById(@PathParam("uid") final String uid) {
        return session.getProvider(MyService.class).findEventsByUid(uid);
    }
	
	@GET
    @Path("/lists/{uids}")
    @NoCache
	@Produces(MediaType.APPLICATION_JSON)
	public List<EventRepresentation> getEventsByIds(@PathParam("uids") final String uids) {
        return session.getProvider(MyService.class).findEventsByUids(uids);
    }
	
}
