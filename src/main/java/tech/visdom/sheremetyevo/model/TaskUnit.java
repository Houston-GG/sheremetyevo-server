package tech.visdom.sheremetyevo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "task_unit", uniqueConstraints = @UniqueConstraint(columnNames = {"TASK_ID", "RUNWAY_UNIT_ID", "TECHNIC_ID"}))
public class TaskUnit {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="TASK_ID", nullable = false)
    private Task task;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="RUNWAY_UNIT_ID", nullable = false)
    private RunwayUnit runwayUnit;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="TECHNIC_ID", nullable = false)
    private Technic technic;

    @Column(name="IS_FINISHED", nullable = false)
    private boolean isFinished;

    public TaskUnit(Task task, RunwayUnit runwayUnit, Technic technic, boolean isFinished) {
        this.task = task;
        this.runwayUnit = runwayUnit;
        this.technic = technic;
        this.isFinished = isFinished;
    }
}
