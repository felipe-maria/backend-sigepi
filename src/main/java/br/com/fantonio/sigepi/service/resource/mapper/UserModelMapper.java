package br.com.fantonio.sigepi.service.resource.mapper;

import br.com.fantonio.sigepi.service.api.model.UserTO;
import br.com.fantonio.sigepi.service.domain.entity.User;
import br.com.fantonio.sigepi.service.domain.entity.type.IssuerFederateUnit;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class UserModelMapper {


    public UserTO convert2To(User entity) {

        ModelMapper modelMapper = getModelMapper();

        return modelMapper.map(entity, UserTO.class);
    }

    public List<UserTO> convert2ToList(List<User> entities) {

        ModelMapper modelMapper = getModelMapper();

        return modelMapper.map(entities, new TypeToken<List<UserTO>>() {}.getType());
    }

    private ModelMapper getModelMapper() {

        Converter<IssuerFederateUnit, String> issuerFederateUnitConverter =
                ctx -> ctx.getSource() == null ? null : ctx.getSource().toString();

        ModelMapper modelMapper = new ModelMapper();
        TypeMap<User, UserTO> typeMap = modelMapper.createTypeMap(User.class, UserTO.class);

        typeMap.addMappings(mapper -> mapper.using(issuerFederateUnitConverter)
                .map(User::getRgIssuerIssuerFederateUnit, UserTO::setRgIssuerFedUnit));

        return modelMapper;
    }

}
