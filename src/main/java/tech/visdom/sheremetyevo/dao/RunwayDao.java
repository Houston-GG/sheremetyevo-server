package tech.visdom.sheremetyevo.dao;

import org.springframework.data.repository.CrudRepository;
import tech.visdom.sheremetyevo.model.Runway;

public interface RunwayDao extends CrudRepository<Runway, Long> {
}
