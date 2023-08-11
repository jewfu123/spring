package org.keycloak.examples.rest.jpa;

/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.keycloak.Config;
import org.keycloak.connections.jpa.JpaConnectionProvider;
import org.keycloak.connections.jpa.entityprovider.JpaEntityProvider;
import org.keycloak.connections.jpa.entityprovider.JpaEntityProviderFactory;
import org.keycloak.events.EventStoreProvider;
import org.keycloak.events.EventStoreProviderFactory;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class MyJpaEventStoreProviderFactory3 implements JpaEntityProviderFactory {

    public static final String ID = "jpa3";
    private int maxDetailLength;

//    @Override
//    public JpaEntityProvider create(KeycloakSession session) {
//        JpaConnectionProvider connection = session.getProvider(JpaConnectionProvider.class);
//        return (JpaEntityProvider) new MyJpaEventStoreProvider(session, connection.getEntityManager(), maxDetailLength);
//    }
    
    @Override
    public JpaEntityProvider create(KeycloakSession session) {
    	System.out.println("***** JPA MyJpaFactory3 create() ****** ");
        return new MyJpaEventProvider3();
    }

    @Override
    public void init(Config.Scope config) {
    	System.out.println("***** JPA MyJpaFactory3 init(Config.Scope config) ****** ");
        maxDetailLength = config.getInt("max-detail-length", 0);
    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {
    	System.out.println("***** JPA MyJpaFactory3 postInit() ****** ");
    }

    @Override
    public void close() {
    	System.out.println("***** JPA MyJpaFactory3 close() ****** ");
    }

    @Override
    public String getId() {
    	System.out.println("***** JPA MyJpaFactory3 getId() ****** ");
        return ID;
    }

}
