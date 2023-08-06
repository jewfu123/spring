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

import org.keycloak.Config.Scope;
import org.keycloak.examples.rest.spi.MyService;
import org.keycloak.examples.rest.spi.JpaEntityProviderFactory;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

public class MyServiceProviderFactoryImpl implements JpaEntityProviderFactory {

    @Override
    public MyService create(KeycloakSession session) {
        return new MyServiceImpl(session);
    }

    @Override
    public void init(Scope config) {
    	System.out.println("------> ExampleServiceProviderFactoryImpl --------> init +++++++ // ");
    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {
    	System.out.println("------> ExampleServiceProviderFactoryImpl --------> postInit +++++++ // ");
    }

    @Override
    public void close() {
    	System.out.println("------> ExampleServiceProviderFactoryImpl --------> close +++++++ // ");
    }

    @Override
    public String getId() {
    	System.out.println("------> ExampleServiceProviderFactoryImpl --------> getId +++++++ // ");
        return "exampleServiceImpl";
    }

}
