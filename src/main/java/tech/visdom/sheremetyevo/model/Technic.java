package tech.visdom.sheremetyevo.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "technic")
public class Technic {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name="NAME", nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="TYPE_ID", nullable=false)
    private Type type;

    @Column(name="MODEL_ID", nullable = false)
    private Long modelId;

    @Column(name="CURRENT_FUEL_RESERVE", nullable = false)
    private Float currentFuelReserve;

    @Column(name="CURRENT_REAGENT_RESERVE", nullable = false)
    private Float currentReagentReserve;

    @Column(name="STATUS_ID", nullable = false)
    private Long statusId;

    @Column(name="LATITUDE", nullable = false)
    private Float latitude;

    @Column(name="LONGITUDE", nullable = false)
    private Float longitude;

    @Column(name="LAST_UPDATE", nullable = false)
    private LocalDateTime lastUpdate;
}
