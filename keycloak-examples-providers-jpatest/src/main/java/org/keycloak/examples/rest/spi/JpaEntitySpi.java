package org.keycloak.examples.rest.spi;

import org.keycloak.provider.Provider;
import org.keycloak.provider.ProviderFactory;
import org.keycloak.provider.Spi;

public class JpaEntitySpi implements Spi {
	
	@Override
	public boolean isInternal() {
		System.out.println("%%%%%%%%%%%%%% JpaEntitySpi ---> isInternal()");
		return false;
	}

	@Override
	public String getName() {
		System.out.println("%%%%%%%%%%%%%% JpaEntitySpi ---> getName()");
		//return "jpa-entity-provider";
		return "hello";
	}

	@Override
	public Class<? extends Provider> getProviderClass() {
		System.out.println("%%%%%%%%%%%%%% JpaEntitySpi ---> getProviderClass()");
		return MyService.class;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class<? extends ProviderFactory> getProviderFactoryClass() {
		System.out.println("%%%%%%%%%%%%%% JpaEntitySpi ---> getProviderFactoryClass()");
		return JpaEntityProviderFactory.class;
	}
}

