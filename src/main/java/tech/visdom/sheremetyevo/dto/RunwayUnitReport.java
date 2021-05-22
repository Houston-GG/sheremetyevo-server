package tech.visdom.sheremetyevo.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RunwayUnitReport {

    @NotNull
    private Long id;

    @NotNull
    private Integer icing;

    @NotNull
    private Integer snowLevel;
}
