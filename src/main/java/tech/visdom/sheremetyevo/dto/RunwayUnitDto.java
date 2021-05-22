package tech.visdom.sheremetyevo.dto;

import lombok.Data;


@Data
public class RunwayUnitDto {

    private Long id;

    private String name;

    private Float latitude;

    private Float longitude;

    private Integer icing;

    private Integer snowLevel;
}
