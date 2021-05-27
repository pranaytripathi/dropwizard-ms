package com.dropwizard.ms;


import com.dropwizard.ms.api.WelcomeResource;
import com.dropwizard.ms.api.rpc.Common;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WelcomeResourceTest {
    private WelcomeResource res = new WelcomeResource();

    @Test
    public void testPostEndpoint() {
        var request =
                Common.CustomWelcomeMessageRequest
                        .newBuilder()
                        .setMessage("Have a drink")
                        .setId(1)
                        .build();
        var response = res.postResponse(request);
        System.out.println(response.getMessage());
        assertNotNull(response.getMessage());
    }

}
