package org.keycloak.examples.domainextension.jpa;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.keycloak.component.ComponentModel;
import org.keycloak.connections.jpa.entityprovider.JpaEntityProvider;
import org.keycloak.events.Event;
import org.keycloak.events.EventQuery;
import org.keycloak.events.EventStoreProvider;
import org.keycloak.events.admin.AdminEvent;
import org.keycloak.events.admin.AdminEventQuery;
import org.keycloak.events.jpa.JpaEventQuery;
import org.keycloak.models.KeycloakSession;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyJpaEntityProvider implements JpaEntityProvider {

	private static final ObjectMapper mapper = new ObjectMapper();
    private static final TypeReference<Map<String, String>> mapType = new TypeReference<Map<String, String>>() {
    };
    private static final Logger logger = Logger.getLogger(MyJpaEntityProvider.class);

    private KeycloakSession session;
    private ComponentModel model;
    private final EntityManager em;
    private final int maxDetailLength;

    public MyJpaEntityProvider(KeycloakSession session, EntityManager em, int maxDetailLength) {
        this.session = session;
        this.em = em;
        this.maxDetailLength = maxDetailLength;
    }
    
    public void SetSession(KeycloakSession session) {
    	this.session = session;
    }
    
    public void SetModel(ComponentModel model) {
    	this.model = model;
    }
    
    public void getH2data() {
    	System.out.println("---- getH2data piao guo ....");
    	//List<EventEntity> events = em.createQuery("select u from EventEntity u", EventEntity.class).getResultList();
    	//System.out.println(events);
    }
    
//	public void onEvent(Event arg0) {
//		System.out.println("---->/MyJpaEntityProvider -------/>/> event ------------//");
//		// TODO Auto-generated method stub
//		this.getH2data();
//	}

//	@Override
//	public void onEvent(AdminEvent arg0, boolean arg1) {
//		// TODO Auto-generated method stub
//		System.out.println("---->/AdminEvent MyJpaEntityProvider -------/>/> AdminEvent event ------------//");
//	}
    
    @Override
    public List<Class<?>> getEntities() {
        return Collections.<Class<?>>singletonList(EventEntity.class);
    }

//    @Override
//    public String getChangelogLocation() {
//    	return "META-INF/example-changelog.xml";
//    }
    
    @Override
    public void close() {
    	
    	System.out.println("------> MyJpaEntity --------> close +++++++ // ");
    }

    @Override
    public String getFactoryId() {
    	this.getH2data();
    	System.out.println("------> MyJpaEntity --------> getFactoryId +++++++ // " + MyJpaEntityProviderFactory.ID);
        return MyJpaEntityProviderFactory.ID;
    }
/*
	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println("---->/MyJpaEntityProvider -------/>/> close ------------//");
	}

	@Override
	public void clear() {
		System.out.println("---->/MyJpaEntityProvider -------/>/> clear ------------//");
		em.createQuery("delete from EventEntity").executeUpdate();
		
	}

	@Override
	public void clear(String realmId) {
		System.out.println("---->/MyJpaEntityProvider -------/>/> clear-realmId ------------//");
		em.createQuery("delete from EventEntity where realmId = :realmId").setParameter("realmId", realmId).executeUpdate();
		
	}

	@Override
	public void clear(String realmId, long olderThan) {
		System.out.println("---->/MyJpaEntityProvider -------/>/> clear-realmId olderThan ------------//");
		em.createQuery("delete from EventEntity where realmId = :realmId and time < :time").setParameter("realmId", realmId).setParameter("time", olderThan).executeUpdate();
		
	}

	@Override
	public void clearAdmin() {
		// TODO Auto-generated method stub
		System.out.println("---->/MyJpaEntityProvider -------/>/> clearAdmin ------------//");
		
	}

	@Override
	public void clearAdmin(String arg0) {
		// TODO Auto-generated method stub
		System.out.println("---->/MyJpaEntityProvider -------/>/> clearAdmin - String ------------//");
	}

	@Override
	public void clearAdmin(String arg0, long arg1) {
		// TODO Auto-generated method stub
		System.out.println("---->/MyJpaEntityProvider -------/>/> clearAdmin - String arg1 ------------//");
	}

	@Override
	public void clearExpiredEvents() {
		// TODO Auto-generated method stub
		System.out.println("---->/MyJpaEntityProvider -------/>/> clearExpiredEvents ------------//");
	}

	@Override
	public AdminEventQuery createAdminQuery() {
		// TODO Auto-generated method stub
		System.out.println("---->/MyJpaEntityProvider -------/>/> AdminEventQuery - createAdminQuery ------------//");
		return null;
	}

	@Override
	public EventQuery createQuery() {
		System.out.println("---->/MyJpaEntityProvider -------/>/> EventQuery createQuery ------------//");
		return new JpaEventQuery(em);
	}

	@Override
	public List<Class<?>> getEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getChangelogLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFactoryId() {
		// TODO Auto-generated method stub
		return null;
	}
*/

	@Override
	public String getChangelogLocation() {
		// TODO Auto-generated method stub
		return null;
	}


}
