package tech.visdom.sheremetyevo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TechnicDto {

    private Long id;

    private String name;

    private TypeDto type;

    private ModelDto model;

    private Float currentFuelReserve;

    private Float currentReagentReserve;

    private TechnicStatusDto status;

    private Float latitude;

    private Float longitude;

    private LocalDateTime lastUpdate;
}
