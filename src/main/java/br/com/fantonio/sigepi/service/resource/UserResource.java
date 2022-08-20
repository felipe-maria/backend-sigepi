package br.com.fantonio.sigepi.service.resource;

import br.com.fantonio.sigepi.service.api.UsersApi;
import br.com.fantonio.sigepi.service.api.model.CreateUserITO;
import br.com.fantonio.sigepi.service.api.model.UserTO;
import br.com.fantonio.sigepi.service.business.CreateUser;
import br.com.fantonio.sigepi.service.business.GetUserById;
import br.com.fantonio.sigepi.service.business.ListAllUsers;
import br.com.fantonio.sigepi.service.domain.entity.User;
import br.com.fantonio.sigepi.service.resource.mapper.UserModelMapper;
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

    @Inject
    UserModelMapper userModelMapper;

    @Override
    public Response createUser(CreateUserITO input) {

        ModelMapper modelMapper = new ModelMapper();
        User entity = modelMapper.map(input, new TypeToken<User>() {}.getType());

        entity = createUser.doIt(entity);
        UserTO to = userModelMapper.convert2To(entity);

        return Response.ok().entity(to).build();
    }

    @Override
    public Response getUserById(Long userId) {

        User entity = getUserById.doIt(userId);
        UserTO to = userModelMapper.convert2To(entity);

        return Response.ok().entity(to).build();
    }

    @Override
    public Response listAllUsers() {
        List<User> entities = listAllUsers.doIt();

        List<UserTO> tos = userModelMapper.convert2ToList(entities);
        return Response.ok().entity(tos).build();
    }
}
