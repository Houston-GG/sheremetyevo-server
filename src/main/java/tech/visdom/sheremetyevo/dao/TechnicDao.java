package tech.visdom.sheremetyevo.dao;

import org.springframework.data.repository.CrudRepository;
import tech.visdom.sheremetyevo.model.Technic;

public interface TechnicDao extends CrudRepository<Technic, Long> {
    Iterable<Technic> findAllByStatusIdAndTypeId(Long status, Long type);
}
