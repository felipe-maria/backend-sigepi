package br.com.fantonio.sigepi.service.resource;

import br.com.fantonio.sigepi.service.api.UsersApi;
import br.com.fantonio.sigepi.service.api.model.CreateUserITO;
import br.com.fantonio.sigepi.service.api.model.UserTO;
import br.com.fantonio.sigepi.service.business.CreateUser;
import br.com.fantonio.sigepi.service.business.GetUserById;
import br.com.fantonio.sigepi.service.business.ListAllUsers;
import br.com.fantonio.sigepi.service.domain.entity.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;


public class UserResource implements UsersApi {

    @Inject
    ListAllUsers listAllUsers;

    @Inject
    CreateUser createUser;

    @Inject
    GetUserById getUserById;

    @Override
    public Response createUser(CreateUserITO input) {

        ModelMapper modelMapper = new ModelMapper();
        User entity = modelMapper.map(input, new TypeToken<User>() {}.getType());

//        createUser.doIt(entity);

        UserTO to = modelMapper.map(input, new TypeToken<UserTO>() {
        }.getType());

        return Response.ok().entity(to).build();
    }

    @Override
    public Response getUserById(Long userId) {

        User user = getUserById.doIt(userId);

        ModelMapper modelMapper = new ModelMapper();
        UserTO to = modelMapper.map(user, new TypeToken<UserTO>() {}.getType());

        return Response.ok().entity(to).build();
    }

    @Override
    public Response listAllUsers() {
        List<User> users = listAllUsers.doIt();

        ModelMapper modelMapper = new ModelMapper();
        List<UserTO> tos = modelMapper.map(users, new TypeToken<List<UserTO>>() {}.getType());

        return Response.ok().entity(tos).build();
    }
}
