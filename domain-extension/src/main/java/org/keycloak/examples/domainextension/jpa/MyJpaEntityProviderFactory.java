package org.keycloak.examples.domainextension.jpa;

import javax.naming.InitialContext;
import javax.persistence.EntityManager;

import org.keycloak.Config;
import org.keycloak.component.ComponentModel;
import org.keycloak.connections.jpa.JpaConnectionProvider;
import org.keycloak.connections.jpa.entityprovider.JpaEntityProvider;
import org.keycloak.connections.jpa.entityprovider.JpaEntityProviderFactory;
import org.keycloak.events.EventStoreProvider;
import org.keycloak.events.EventStoreProviderFactory;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

public class MyJpaEntityProviderFactory implements JpaEntityProviderFactory {
	
	public static final String ID = "myjpa";
	
	private EntityManager em;
	
    private int maxDetailLength;

//    @Override
//    public EventStoreProvider create(KeycloakSession session) {
//        JpaConnectionProvider connection = session.getProvider(JpaConnectionProvider.class);
//        return new MyJpaEntityProvider(session, connection.getEntityManager(), maxDetailLength);
//    }
    
    @Override
    public JpaEntityProvider create(KeycloakSession session) {
    	System.out.println("======= to create myjpaprovider by k -=======");
    	return (JpaEntityProvider) new MyJpaEntityProvider(session, null, 0);
    }
    
    
    public MyJpaEntityProvider create(KeycloakSession session, EntityManager em, ComponentModel model) {
        System.out.println("======= to create myjpaprovider by k e c -=======");
    	try {
            InitialContext ctx = new InitialContext();
            MyJpaEntityProvider provider = (MyJpaEntityProvider)ctx.lookup("java:global/event-keycloak/" + MyJpaEntityProvider.class.getSimpleName());
            provider.SetModel(model);
            provider.SetSession(session);
            return provider;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
//    @Override
//    public EventStoreProvider create(KeycloakSession session) {
//        return new MyJpaEntityProvider(session, null, maxDetailLength);
//    }
    
//    @Override
//    public EventStoreProvider create(KeycloakSession session) {
//    	return (EventStoreProvider) new ExampleJpaEntityProvider();
//    }

    @Override
    public void init(Config.Scope config) {
        maxDetailLength = config.getInt("max-detail-length", 0);
        System.out.println("------> MyJpaEntityProviderFactory --------> init +++++++ // ");
    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {
    	System.out.println("------> MyJpaEntityProviderFactory --------> postInit +++++++ // ");
    }

    @Override
    public void close() {
    	System.out.println("------> MyJpaEntityProviderFactory --------> close +++++++ // ");
    }

    @Override
    public String getId() {
    	System.out.println("------> MyJpaEntityProviderFactory --------> getId +++++++ // ");
        return ID;
    }
    


}
