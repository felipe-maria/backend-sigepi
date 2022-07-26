package br.com.fantonio.sigepi.service.resource;

import br.com.fantonio.sigepi.service.api.UsersApi;
import br.com.fantonio.sigepi.service.api.model.UserTO;
import br.com.fantonio.sigepi.service.business.ListAllUsers;
import br.com.fantonio.sigepi.service.domain.entity.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

public class UserResource implements UsersApi {

    @Inject
    private ListAllUsers listAllUsers;

    @Override
    public Response listAllUsers() {
        List<User> users = listAllUsers.doIt();

        ModelMapper modelMapper = new ModelMapper();
        List<UserTO> tos = modelMapper.map(users, new TypeToken<List<UserTO>>() {}.getType());

        return Response.ok().entity(tos).build();
    }
}
