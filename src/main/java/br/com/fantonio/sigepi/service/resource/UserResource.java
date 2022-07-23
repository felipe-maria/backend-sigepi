package br.com.fantonio.sigepi.service.resource;

import br.com.fantonio.sigepi.service.domain.entity.User;
import br.com.fantonio.sigepi.service.domain.repository.UserRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
public class UserResource {

    @Inject
    UserRepository userRepository;

    @GET
    public Response getUsers(){
        List<User> users = userRepository.findAll().list();
        users.forEach(user ->
                System.out.println(String.format("Id: %s - Nome: %s", user.getId(), user.getName()))
        );
        return Response.ok().build();
    }
}
