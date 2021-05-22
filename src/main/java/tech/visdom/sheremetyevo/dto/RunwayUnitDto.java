package tech.visdom.sheremetyevo.dto;

import lombok.Data;

import java.util.List;

@Data
public class RunwayUnitDto {

    private Long id;

    private String name;

    private Float latitude;

    private Float longitude;

    private Integer icing;

    private Integer snowLevel;

    private List<ServicePointDto> servicePoints;
}
