package br.com.fantonio.sigepi.service.business;

import br.com.fantonio.sigepi.service.domain.entity.User;
import br.com.fantonio.sigepi.service.domain.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class GetUserById {

    @Inject
    UserRepository userRepository;

    public User doIt(Long userId) {

        return userRepository.findById(userId);
    }
}
