package tech.visdom.sheremetyevo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class RoleDto {

    private Long id;

    private String name;

    private String description;
}
