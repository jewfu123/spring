package org.keycloak.examples.rest.jpa;

import java.util.Collections;
import java.util.List;

import org.keycloak.connections.jpa.entityprovider.JpaEntityProvider;

public class MyJpaEventProvider3 implements JpaEntityProvider {

	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println("***** --- JPA MyJpaProvider3 close() ****** ");
	}

	@Override
	public List<Class<?>> getEntities() {
		System.out.println("***** --- JPA MyJpaProvider3 List<Class<?>> getEntities() ****** ");
		return Collections.<Class<?>>singletonList(UserAttribute.class);
	}

	@Override
	public String getChangelogLocation() {
		System.out.println("***** --- JPA MyJpaProvider3 getChangelogLocation() ****** ");
		return null;
	}

	@Override
	public String getFactoryId() {
		System.out.println("***** --- JPA MyJpaProvider3 getFactoryId() ****** ");
		return MyJpaEventStoreProviderFactory3.ID;
	}

}
