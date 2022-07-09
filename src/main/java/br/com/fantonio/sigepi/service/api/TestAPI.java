package br.com.fantonio.sigepi.service.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/test")
public class TestAPI {

    @GET
    public String helloWorld() {
        return "Hellow World!";
    }

}
