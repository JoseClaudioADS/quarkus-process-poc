package org.acme.commandmode;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@RegisterRestClient(configKey="api-service")
public interface ApiService {

    @GET
    @Path("/comments")
    @Produces(MediaType.APPLICATION_JSON)
    Set<CommentResponse> getComments();
}
