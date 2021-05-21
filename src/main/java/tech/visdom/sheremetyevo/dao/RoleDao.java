package tech.visdom.sheremetyevo.dao;

import org.springframework.data.repository.CrudRepository;
import tech.visdom.sheremetyevo.model.Role;

public interface RoleDao extends CrudRepository<Role, Long> {
}
