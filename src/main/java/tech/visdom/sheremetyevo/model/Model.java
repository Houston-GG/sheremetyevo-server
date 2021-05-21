package tech.visdom.sheremetyevo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "model")
public class Model {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name="NAME", nullable = false, unique = true)
    private String name;

    @Column(name="POWER", nullable = false)
    private Integer power;

    @Column(name="MAX_FUEL_RESERVE", nullable = false)
    private Float maxFuelReserve;

    @Column(name="MAX_REAGENT_RESERVE", nullable = false)
    private Float maxReagentReserve;

    @Column(name="REAGENT_CONSUMPTION", nullable = false)
    private Float reagentConsumption;

    @Column(name="FUEL_CONSUMPTION", nullable = false)
    private Float fuelConsumption;
}
