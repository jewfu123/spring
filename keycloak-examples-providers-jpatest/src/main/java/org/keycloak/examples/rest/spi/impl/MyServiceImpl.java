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

package org.keycloak.examples.rest.spi.impl;

import org.keycloak.connections.jpa.JpaConnectionProvider;
import org.keycloak.examples.rest.EventRepresentation;
import org.keycloak.examples.rest.EventUserRepresentation;
import org.keycloak.examples.rest.UserEntityPresentation;
import org.keycloak.examples.rest.jpa.EventEntity;
import org.keycloak.examples.rest.jpa.UserEntity2;
import org.keycloak.examples.rest.spi.MyService;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.jpa.entities.UserEntity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.EntityManager;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class MyServiceImpl implements MyService {

    private final KeycloakSession session;

    public MyServiceImpl(KeycloakSession session) {
        this.session = session;
        System.out.println("now is here: ---- ExampleServiceImpl: session: " + session);
        if (getRealm() == null) {
            throw new IllegalStateException("The service cannot accept a session without a realm in its context.");
        }
    }

    private EntityManager getEntityManager() {
    	System.out.println("---- EntityManager getEntityManager() ---------");
        return session.getProvider(JpaConnectionProvider.class).getEntityManager();
    }

    protected RealmModel getRealm() {
    	System.out.println("---- RealmModel getRealm() ---------");
        return session.getContext().getRealm();
    }
    
    @Override
    public List<EventUserRepresentation> listEvents() {
    	System.out.println("-- ExampleServiceImpl -- List<EventRepresentation> listCompanies() ---------");
    	//List<EventEntity> companyEntities = getEntityManager().createNamedQuery("findAll", EventEntity.class)
    	List<EventEntity> companyEntities = getEntityManager().createNamedQuery("findAll", EventEntity.class).getResultList();
    	
    	List<UserEntity2> userEntities = getEntityManager().createNamedQuery("ue_findAll", UserEntity2.class).getResultList();
    	// ---- 2023-8-11 ---- use src's entity
    	List<UserEntity> srcUserEntity = getEntityManager().createNamedQuery("getAllUsersByRealm", UserEntity.class)
    			.setParameter("realmId", "45cb5a0a-321e-4404-b458-b5e325b4a2a9")
    			.getResultList();
    	System.out.println("------- get results by src UserEntity  ----<------- begin -------->");
    	System.out.println(srcUserEntity.toString());
    	List<UserEntityPresentation> result44 = new LinkedList<>();
    	for (UserEntity ett : srcUserEntity) {
    		System.out.println(ett.toString());
    		result44.add(new UserEntityPresentation(ett));
    	    //Assert.assertEquals(employee.getName(), map.get("name"));
    	    //Assert.assertEquals(employee.getAge(), map.get("salary"));
    	}
    	System.out.println(result44);
    	System.out.println("------- get results by src UserEntity  ----<------- end -------->");
    	System.out.println("-------------------------->");
    	System.out.println(userEntities.toString());
    	System.out.println("------------------ 888 -------->");
//                .setParameter("realmId", getRealm().getId())
//                .getResultList();
    	//System.out.println(companyEntities.toString());
        ///List<EventRepresentation> result = new LinkedList<>();
    	List<EventUserRepresentation> result = new LinkedList<>();
        for (EventEntity entity : companyEntities) {
        	System.out.println(entity.toString());
        	for (UserEntity2 ueet : userEntities) {
        		System.out.println(ueet.getUsername());
        		System.out.println(ueet.getFirstName());
        		if (ueet.getId().equals(entity.getUSER_ID())) {
        			System.out.println("----- !!!!!!!!! ----------- !!!!!!!! selected ----- !!!!!!!!! ----------- !!!!!!!!");
        			result.add(new EventUserRepresentation(entity, ueet));
        		}
        	}
            ///result.add(new EventRepresentation(entity));
        }
        System.out.println(result);
        return result;
    }

    public void close() {
        // Nothing to do.
    	System.out.println("------> ExampleServiceProviderImpl --------> close +++++++ // ");
    }
    
    @Override
    public List<EventRepresentation> findEventsByUid(String uid) {
    	//List<String> empNumbers = Arrays.asList("A123", "A124");
    	List<EventEntity> eventEntities = getEntityManager().createNamedQuery("getByUid", EventEntity.class)
    			.setParameter("uid", uid)
    			.getResultList();
    	List<EventRepresentation> result = new LinkedList<>();
        for (EventEntity entity : eventEntities) {
            result.add(new EventRepresentation(entity));
        }
        return result;
    }
    
    @Override
    public List<EventRepresentation> findEventsByUids(String uids) {
    	//List<String> empNumbers = Arrays.asList("42c5113d-ef56-4040-a8cd-1bfd1d070088","a037f2ba-e522-4c75-8666-f7922b7f35ea");
//    	List<String> tmpUids = new LinkedList<>();
//    	for (String uid : uids) {
//    		tmpUids.add(uid);
//        }
    	//Vector<String> uidsss = new Vector<String>();
    	List<String> empNumbers = Arrays.asList(uids.split(","));
    	// -----------
    	//List<String> empNumbers = Arrays.asList(uids.toString());
    	List<EventEntity> eventEntities = getEntityManager().createNamedQuery("getByUids", EventEntity.class)
    			.setParameter("uids", empNumbers)
    			.getResultList();
    	
    	List<EventRepresentation> result = new LinkedList<>();
        for (EventEntity entity : eventEntities) {
            result.add(new EventRepresentation(entity));
        }
        return result;
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


}
