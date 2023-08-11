Example Realm REST Resource provider
====================================

You can deploy as a module by running:

    $KEYCLOAK_HOME/bin/jboss-cli.sh --command="module add --name=org.keycloak.examples.hello-rest-example --resources=target/hello-rest-example.jar --dependencies=org.keycloak.keycloak-core,org.keycloak.keycloak-server-spi,org.keycloak.keycloak-server-spi-private,javax.ws.rs.api"

Then registering the provider by editing `standalone/configuration/standalone.xml` and adding the module to the providers element:

    <providers>
        ...
        <provider>module:org.keycloak.examples.hello-rest-example</provider>
    </providers>

Then start (or restart) the server. Once started open http://localhost:8080/auth/realms/master/hello and you should see the message _Hello master_.
You can also invoke the endpoint for other realms by replacing `master` with the realm name in the above url.


http://localhost:8180/auth/realms/master/hello

http://localhost:8180/auth/realms/master/hello/hello

//——————— 2023-8-6 —————//

++++++++++++ for event.
jboss-cli.sh --command="module add --name=org.keycloak.examples.event-check --resources=target/hello-rest-example.jar --dependencies=org.keycloak.keycloak-core,org.keycloak.keycloak-services,org.keycloak.keycloak-model-jpa,org.keycloak.keycloak-server-spi,org.keycloak.keycloak-server-spi-private,javax.ws.rs.api,javax.persistence.api,org.hibernate,org.javassist,org.liquibase"

<provider>module:org.keycloak.examples.event-check</provider>

*remove:
jboss-cli.sh --command="module remove --name=org.keycloak.examples.event-check"

+++++++++++++++++++++

http://localhost:8180/auth/realms/master/hello

http://localhost:8180/auth/realms/master/hello/hello

[get] ok take all events:
http://localhost:8180/auth/realms/master/hello/listall

[get] ok by user_id(one):
http://localhost:8180/auth/realms/master/hello/list/uid
http://localhost:8180/auth/realms/master/hello/list/42c5113d-ef56-4040-a8cd-1bfd1d070088
http://localhost:8180/auth/realms/master/hello/list/a037f2ba-e522-4c75-8666-f7922b7f35ea
http://localhost:8180/auth/realms/master/hello/list/d564c863-d7a6-490d-9bae-072d89be5c68

[get] ok by user_ids(more,split_by_,,,,,):
http://localhost:8180/auth/realms/master/hello/lists/d564c863-d7a6-490d-9bae-072d89be5c68,a037f2ba-e522-4c75-8666-f7922b7f35ea

[post] by user_ids(many): somethings must be broken then can use it.
http://localhost:8180/auth/realms/master/hello/list
uids [array] son

//———
http://localhost:8180/auth/realms/master/example

http://localhost:8180/auth/realms/master/example/companies

//——————— 2023-8-11 14:22 Summary —————// 11:29 the second hard be solved.

##About Jpa:

1. JPA is a pass Object to controll data's method.

2. If you want to run sql in database and then make Data Model, that isn't JPA. The right method is reay Data Model then controll them and the result data is become!

##About Keycloak's spi:

1. If you want used your custom Entity, you must Factory at first, and then create provider,entity.

2. If you used the keycloak's Model Entity, unneed do above. Just import it directly.

3. Data Model not equal to the result data's construct. The result data's construct by EntityRepresentation.

4. The mapper must be designed correctly to refer to the data model, not the structure of the final result data.

5. More sample from keycloak's data models can be refered. And @OneToMany....

## New week's modify:
1. Only use one customer entity EventUser(Event_Ex view)

2. Add two lines named sql append of above.

3. import UserAttributeEntity into Impl and add createsql("select 1234 from ..... where name in(1,2,3,4) and user_id in(1,2,3,4,5....)", UserAttribute.class).setParameter("uids",ssssss).getResultList();

4. create a new EntityRepresentation can import two entities(eventuser, userattribute) then make new object json

5. take above representation into Impl and make the result data.

6. at last change the uids from strings(1,2,3,4...) to list[1,2,3,4]!!!


