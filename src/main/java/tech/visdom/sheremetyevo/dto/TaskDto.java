package tech.visdom.sheremetyevo.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class TaskDto {

    private Long id;

    private LocalDateTime initTime;

    private LocalDateTime approximateFinishTime;

    private LocalDateTime finishTime;

    private UserDto operator;

    private Long taskStatusId;

    @NotNull
    private List<TaskUnitDto> taskUnits;
}
