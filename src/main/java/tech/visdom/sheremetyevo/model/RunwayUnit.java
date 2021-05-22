package tech.visdom.sheremetyevo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "runway_unit")
public class RunwayUnit {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="runway_ID", nullable = false)
    private Runway runway;

    @Column(name="NAME", nullable = false, unique = true)
    private String name;

    @Column(name="LATITUDE", nullable = false)
    private Float latitude;

    @Column(name="LONGITUDE", nullable = false)
    private Float longitude;

    @Column(name="ICING", nullable = false)
    private Integer icing;

    @Column(name="SNOW_LEVEL", nullable = false)
    private Integer snowLevel;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "unit_service_point",
            joinColumns = @JoinColumn(name = "RUNWAY_UNIT_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "SERVICE_POINT_ID", referencedColumnName = "ID")
    )
    private List<ServicePoint> servicePoints;

    public RunwayUnit(Long id) {
        this.id = id;
    }
}
