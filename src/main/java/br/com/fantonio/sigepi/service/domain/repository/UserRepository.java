package br.com.fantonio.sigepi.service.domain.repository;

import br.com.fantonio.sigepi.service.domain.entity.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

}
