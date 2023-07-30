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

package org.keycloak.examples.rest;

import org.keycloak.models.KeycloakSession;
import org.keycloak.services.resource.RealmResourceProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class HelloResourceProvider implements RealmResourceProvider {
	
	@PersistenceContext(unitName = "standalonePu")
    private EntityManager entityManager;
	
    private KeycloakSession session;
    
    public HelloResourceProvider(KeycloakSession session) {
        this.session = session;
    }

    @Override
    public Object getResource() {
        return this;
    }
    
    @GET
    @Path("/hello")
    @Produces("text/plain; charset=utf-8")
    public String getHello() {
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("standalonePu");
    	System.out.println(entityManagerFactory);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
    	System.out.println(entityManager);
    	entityManager.getTransaction().begin();
//    	
//    	EmployeeEntity student = new EmployeeEntity();
//    	student.setNAME("fuhong");
//    	student.setCARD("superman");
//        entityManager.persist(student);
//        entityManager.getTransaction().commit();
//    	
//    	entityManager.close();
//    	entityManagerFactory.close();
    	EventEntity testEntity = new EventEntity();
    	testEntity.setId("5d9d06d7-1399-4064-b4a9-88a2ecbf8644");
    	System.out.println(testEntity); // ok
//        testEntity.setNAME("shazi");
//        testEntity.setCARD("da ge shi chunzhu");
        System.out.println(testEntity);
        System.out.println(entityManager);  // is null
        entityManager.persist(testEntity);
        entityManager.getTransaction().commit();
        return "Hello ";
    }

    @GET
    @Produces("text/plain; charset=utf-8")
    public String get() {
        String name = session.getContext().getRealm().getDisplayName();
        if (name == null) {
            name = session.getContext().getRealm().getName();
        }
        return "Hello " + name;
    }

    @Override
    public void close() {
    }

}
