package br.com.fantonio.sigepi.service.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/test")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TestAPI {

    @GET
    public Response helloWorld() {

        HelloObject message = new HelloObject("Hello World!!");

        return Response.ok().entity(message).build();
    }

    private class HelloObject {
        private final String message;

        public HelloObject(String message) {
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }

    }


}
