package tech.visdom.sheremetyevo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "service_point")
public class ServicePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="NAME", nullable = false, unique = true)
    private String name;

    @Column(name="DESCRIPTION", nullable = false)
    private String description;
}
