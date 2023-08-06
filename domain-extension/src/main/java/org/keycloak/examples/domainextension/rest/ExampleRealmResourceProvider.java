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

package org.keycloak.examples.domainextension.rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.keycloak.component.ComponentModel;
import org.keycloak.examples.domainextension.EventRepresentation;
import org.keycloak.examples.domainextension.jpa.EventEntity;
import org.keycloak.models.KeycloakSession;
import org.keycloak.services.resource.RealmResourceProvider;

public class ExampleRealmResourceProvider implements RealmResourceProvider {

	@PersistenceContext
    protected EntityManager em;

    protected ComponentModel model;
    protected KeycloakSession session;

    public void setModel(ComponentModel model) {
        this.model = model;
    }

    public void setSession(KeycloakSession session) {
        this.session = session;
    }
    
    //private KeycloakSession session;

    public ExampleRealmResourceProvider(KeycloakSession session) {
        this.session = session;
    }

    @Override
    public Object getResource() {
    	System.out.println("--- da sha bi xi jin ping ---> RealmResourceProvider --------> getResource +++++++ // ");
        //return new ExampleRestResource(session);
        
        // ------
//        TypedQuery<EventEntity> query = em.createNamedQuery("findAll", EventEntity.class);
//        List<EventEntity> result = query.getResultList();
//        if (result.isEmpty()) {
//            //logger.info("could not find username: " + username);
//            return null;
//        }
//        System.out.println(result);
//        return new ExampleRestResource(session);
        // -----
    	return new ExampleRestResource(session);
        //return new EventRepresentation(em, model, result.get(0));

    }

    @Override
    public void close() {
    	System.out.println("------> RealmResourceProvider --------> close +++++++ // ");
    }

}

