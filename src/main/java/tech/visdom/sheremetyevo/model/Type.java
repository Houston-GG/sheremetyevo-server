package tech.visdom.sheremetyevo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "type")
public class Type {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name="NAME", nullable = false, unique = true)
    private String name;

    @Column(name="DESCRIPTION", nullable = false)
    private String description;
}
