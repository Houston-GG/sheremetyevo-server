package tech.visdom.sheremetyevo.dao;

import org.springframework.data.repository.CrudRepository;
import tech.visdom.sheremetyevo.model.TaskUnit;

public interface TaskUnitDao extends CrudRepository<TaskUnit, Long> {
    Iterable<TaskUnit> findAllByTechnicId(Long technicId);
}
