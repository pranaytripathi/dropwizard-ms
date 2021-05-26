package com.dropwizard.ms.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.dropwizard.ms.data.UserData;
import org.h2.engine.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserDetailsResource {

    public static Logger logger = LoggerFactory.getLogger(UserDetailsResource.class);

    @GET
    @Timed
    public UserDetails getUserDetails(@QueryParam("id") Integer id) {
        logger.info("Getting user details for user id: " +  id);
        return UserData.getUserData(id);
    }
}
