package tech.visdom.sheremetyevo.dto;

import lombok.Data;

import java.util.List;

@Data
public class RunwayDto {

    private Long id;

    private String name;

    private boolean outside;

    private List<RunwayUnitDto> units;
}
