package tech.visdom.sheremetyevo.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class NewTaskDto {

    @NotNull
    private Long runwayUnitId;

    @NotNull
    private Set<Long> technicIds;
}
