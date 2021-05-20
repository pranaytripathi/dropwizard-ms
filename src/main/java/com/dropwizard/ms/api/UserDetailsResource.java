package com.dropwizard.ms.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.dropwizard.ms.data.UserData;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserDetailsResource {

    private final String template;
    private final String defaultName;

    public UserDetailsResource(String templateName, String defaultName) {
        this.template = templateName;
        this.defaultName = defaultName;
    }

    @GET
    @Timed
    public UserDetails getUserDetails(@QueryParam("id") Integer id) {

        return UserData.getUserData(id);
    }
}
