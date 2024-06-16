package org.acme;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.models.Greeting;
import org.jboss.resteasy.reactive.RestQuery;

@Path("/hello")
public class GreetingResource {

    @GET
    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@RestQuery String name) {
        var greeting = new Greeting();
        greeting.name = name;
        greeting.persist();

        return "Hello " + name;
    }
}
