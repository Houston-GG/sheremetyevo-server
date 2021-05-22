package tech.visdom.sheremetyevo.dto;

import lombok.Data;

@Data
public class TaskUnitDto {

    private Long id;

    private RunwayUnitDto runwayUnit;

    private TechnicDto technic;

    private boolean isFinished;
}
