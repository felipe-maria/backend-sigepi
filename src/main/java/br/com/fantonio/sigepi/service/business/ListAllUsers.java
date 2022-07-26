package br.com.fantonio.sigepi.service.business;

import br.com.fantonio.sigepi.service.domain.entity.User;
import br.com.fantonio.sigepi.service.domain.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ListAllUsers {

    @Inject
    UserRepository userRepository;

    public List<User> doIt() {
        return userRepository.findAll().list();
    }

}
