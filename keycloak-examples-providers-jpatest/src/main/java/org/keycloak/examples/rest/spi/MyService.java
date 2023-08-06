package org.keycloak.examples.rest.spi;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.keycloak.examples.rest.EventRepresentation;
import org.keycloak.provider.Provider;

public interface MyService extends Provider {

	List<Class<?>> getEntities();
	List<EventRepresentation> listEvents();
	
	String getChangelogLocation();
	
	//String getFactoryId();
	List<EventRepresentation> findEventsByUid(String uid);
	
	List<EventRepresentation> findEventsByUids(String uids);
}
