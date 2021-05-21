package tech.visdom.sheremetyevo.dto;

import lombok.Data;

@Data
public class ModelDto {

    private Long id;

    private String name;

    private Integer power;

    private Float maxFuelReserve;

    private Float maxReagentReserve;

    private Float reagentConsumption;

    private Float fuelConsumption;
}
