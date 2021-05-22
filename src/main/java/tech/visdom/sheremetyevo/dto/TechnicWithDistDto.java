package tech.visdom.sheremetyevo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TechnicWithDistDto {


    private TechnicDto technicDto;
    private long dist;
}
