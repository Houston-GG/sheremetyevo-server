package tech.visdom.sheremetyevo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TechnicDto {

    private Long id;

    private String name;

    private Long typeId;

    private Long modelId;

    private Float currentFuelReserve;

    private Float currentReagentReserve;

    private Long statusId;

    private Float latitude;

    private Float longitude;

    private LocalDateTime lastUpdate;
}
