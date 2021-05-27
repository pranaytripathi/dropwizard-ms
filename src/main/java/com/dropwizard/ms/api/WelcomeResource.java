package com.dropwizard.ms.api;

import com.dropwizard.ms.api.rpc.Common;
import com.dropwizard.ms.data.UserData;
import io.dropwizard.jersey.protobuf.ProtocolBufferMediaType;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.net.http.HttpRequest;

@Path("/welcome")
public class WelcomeResource {
    @GET
    @Produces(ProtocolBufferMediaType.APPLICATION_PROTOBUF)
    public Common.Sample res() {
        return Common.Sample
                .newBuilder()
                .setMessage("Welcome to the Dropwizard example API")
                .build();
    }

    @POST
    @Consumes({ProtocolBufferMediaType.APPLICATION_PROTOBUF, ProtocolBufferMediaType.APPLICATION_PROTOBUF_TEXT})
    @Produces({ProtocolBufferMediaType.APPLICATION_PROTOBUF, ProtocolBufferMediaType.APPLICATION_PROTOBUF_TEXT})
    public Common.CustomWelcomeMessageResponse postResponse(final Common.CustomWelcomeMessageRequest messageRequest) {
        var user = UserData.getUserData(messageRequest.getId());
        return Common.CustomWelcomeMessageResponse
                .newBuilder()
                .setMessage(user.getName().concat(" " + messageRequest.getMessage()))
                .build();
    }
}
