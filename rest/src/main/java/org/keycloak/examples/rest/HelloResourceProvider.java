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

import org.jboss.resteasy.annotations.cache.NoCache;
import org.keycloak.connections.jpa.JpaConnectionProvider;
import org.keycloak.connections.jpa.entityprovider.JpaEntityProvider;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.jpa.entities.UserAttributeEntity;
import org.keycloak.models.jpa.entities.UserEntity;
import org.keycloak.services.resource.RealmResourceProvider;
import javax.persistence.EntityManager;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.LinkedList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class HelloResourceProvider implements RealmResourceProvider,JpaEntityProvider {

    private KeycloakSession session;

    public HelloResourceProvider(KeycloakSession session) {
        this.session = session;
    }

    private EntityManager getEntityManager() {
    	System.out.println("---- EntityManager getEntityManager() ---------");
        return session.getProvider(JpaConnectionProvider.class).getEntityManager();
    }
    
    @Override
    public Object getResource() {
    	System.out.println("---- Hello Provider getResource() ---------");
        return this;
    }
    
    @GET
    @NoCache
    @Path("/listall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserEntityPresentation> getEvents(@PathParam("uid") final String uid) {
    	List<UserEntity> srcUserEntity = getEntityManager().createNamedQuery("getAllUsersByRealm", UserEntity.class)
    			.setParameter("realmId", "45cb5a0a-321e-4404-b458-b5e325b4a2a9")
    			.getResultList();
    	List<UserAttributeEntity> uaee = getEntityManager().createQuery("select u from UserAttributeEntity u", UserAttributeEntity.class).getResultList();
    	System.out.println(srcUserEntity.toString());
    	List<UserEntityPresentation> result = new LinkedList<>();
    	//List<Map<String, String>> mylm = new LinkedList<>();
    	Map<String, String> students = new HashMap<>();
    	students.put("name", "wangba");
    	students.put("commpany", "zg");
    	students.put("instudy", "zz");
    	students.put("email", "zgxiatai@zg.com");

    	for (UserEntity et : srcUserEntity) {
    		for (UserAttributeEntity uaetmp : uaee) {
    			if (et.getId().equals(uaetmp.getUser().getId())) {
    				result.add(new UserEntityPresentation(et, students));
    			}
    		}
    		//result.add(new UserEntityPresentation(et,  ));
    	}
    	return result;
        //return session.getProvider(MyService.class).findEventsByUid(uid);
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
    	System.out.println("---- Hello Provider close() ---------");
    }

	@Override
	public List<Class<?>> getEntities() {
		// TODO Auto-generated method stub
		System.out.println("---- Hello Provider getEntities() ---------");
		//return null;
		return Collections.<Class<?>>singletonList(UserEntity.class);
	}

	@Override
	public String getChangelogLocation() {
		// TODO Auto-generated method stub
		System.out.println("---- Hello Provider getChangelogLocation() ---------");
		return null;
	}

	@Override
	public String getFactoryId() {
		// TODO Auto-generated method stub
		System.out.println("---- Hello Provider getFactoryId() ---------");
		return HelloResourceProviderFactory.ID;
	}

}
