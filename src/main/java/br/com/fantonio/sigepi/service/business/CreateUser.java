package br.com.fantonio.sigepi.service.business;

import br.com.fantonio.sigepi.service.domain.entity.User;
import br.com.fantonio.sigepi.service.domain.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class CreateUser {

    @Inject
    UserRepository userRepository;

    @Transactional
    public User doIt(User user) {
        userRepository.persist(user);

        return user;
    }

}
