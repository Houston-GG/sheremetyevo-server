package tech.visdom.sheremetyevo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "runway")
public class Runway {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name="NAME", nullable = false, unique = true)
    private String name;

    @Column(name="OUTSIDE", nullable = false)
    private boolean outside;

    @OneToMany(mappedBy = "runway", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<RunwayUnit> units;
}
