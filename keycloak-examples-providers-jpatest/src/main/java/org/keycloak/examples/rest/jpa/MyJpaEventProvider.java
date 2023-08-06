package org.keycloak.examples.rest.jpa;

import java.util.Collections;
import java.util.List;

import org.keycloak.connections.jpa.entityprovider.JpaEntityProvider;

public class MyJpaEventProvider implements JpaEntityProvider {

	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println("***** --- JPA MyJpaProvider close() ****** ");
	}

	@Override
	public List<Class<?>> getEntities() {
		System.out.println("***** --- JPA MyJpaProvider List<Class<?>> getEntities() ****** ");
		return Collections.<Class<?>>singletonList(EventEntity.class);
	}

	@Override
	public String getChangelogLocation() {
		System.out.println("***** --- JPA MyJpaProvider getChangelogLocation() ****** ");
		return null;
	}

	@Override
	public String getFactoryId() {
		System.out.println("***** --- JPA MyJpaProvider getFactoryId() ****** ");
		return MyJpaEventStoreProviderFactory.ID;
	}

}
