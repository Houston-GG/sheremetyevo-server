package tech.visdom.sheremetyevo.dao;

import org.springframework.data.repository.CrudRepository;
import tech.visdom.sheremetyevo.model.User;

import java.util.Optional;

public interface UserDao extends CrudRepository<User, Long> {

    Optional<User> findByLogin(String login);
}
