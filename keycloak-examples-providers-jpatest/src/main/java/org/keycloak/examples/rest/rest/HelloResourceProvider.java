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

package org.keycloak.examples.rest.rest;

import org.keycloak.models.KeycloakSession;
import org.keycloak.services.resource.RealmResourceProvider;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class HelloResourceProvider implements RealmResourceProvider {
	
	@PersistenceContext(unitName = "standalonePu")
    private EntityManager entityManager;
	
	private final EntityManager em;
	
    private KeycloakSession session;
    
    public HelloResourceProvider(KeycloakSession session, EntityManager em) {
    	System.out.println("HelloResourceProvider --- ");
        this.session = session;
        this.em = em;
        System.out.println("HelloResourceProvider --- session:" + session.toString());
        System.out.println("HelloResourceProvider --- em:" + em.toString());
    }
    
    
    @Override
    public Object getResource() {
    	System.out.println("&&&&$$$##@@@ HelloResourceProvider --- getResource()");
        return new HelloRestResource(session);
    }
    
    @Override
    public void close() {
    	System.out.println("------ HelloResourceProvider ---> close()");
    }

}
