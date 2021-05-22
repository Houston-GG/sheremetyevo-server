package tech.visdom.sheremetyevo.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "task")
public class Task {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name="INIT_TIME", nullable = false)
    private LocalDateTime initTime;

    @Column(name="APPROXIMATE_FINISH_TIME", nullable = false)
    private LocalDateTime approximateFinishTime;

    @Column(name="FINISH_TIME")
    private LocalDateTime finishTime;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="OPERATOR_ID", nullable = false)
    private User operator;

    @Column(name="TASK_STATUS_ID", nullable = false)
    private Long taskStatusId;

    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<TaskUnit> taskUnits;
}
