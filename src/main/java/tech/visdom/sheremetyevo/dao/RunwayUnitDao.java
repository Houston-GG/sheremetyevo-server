package tech.visdom.sheremetyevo.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tech.visdom.sheremetyevo.model.RunwayUnit;

public interface RunwayUnitDao extends CrudRepository<RunwayUnit, Long> {

    @Modifying
    @Query(value = "UPDATE RunwayUnit ru " +
            "SET ru.icing = :icing, ru.snowLevel = :snowLevel " +
            "WHERE ru.id = :runwayUnitID")
    void updateUnit(@Param("runwayUnitID") Long runwayUnitID,
                                 @Param("icing") Integer icing,
                                 @Param("snowLevel") Integer snowLevel);
}
