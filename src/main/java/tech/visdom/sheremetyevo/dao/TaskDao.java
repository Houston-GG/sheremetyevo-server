package tech.visdom.sheremetyevo.dao;

import org.springframework.data.repository.CrudRepository;
import tech.visdom.sheremetyevo.model.Task;

public interface TaskDao extends CrudRepository<Task, Long> {
}
