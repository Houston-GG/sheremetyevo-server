package tech.visdom.sheremetyevo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name="LOGIN", nullable = false)
    private String login;

    @Column(name="PASSWORD", nullable = false)
    private String password;

    @Column(name="NAME", nullable = false)
    private String name;

    @Column(name = "SURNAME", nullable = false)
    private String surname;

    @Column(name = "PATRONYMIC", nullable = false)
    private String patronymic;

    @Column(name = "PHONE", nullable = false)
    private String phone;

    @Column(name = "POST", nullable = false)
    private String post;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE ,CascadeType.PERSIST})
    @JoinTable(
            name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    )
    private List<Role> roles;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE ,CascadeType.PERSIST})
    @JoinTable(
            name = "user_technic",
            joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "TECHNIC_ID", referencedColumnName = "ID")
    )
    private Set<Technic> technics;
}
