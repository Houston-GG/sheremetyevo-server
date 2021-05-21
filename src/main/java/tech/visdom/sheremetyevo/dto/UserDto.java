package tech.visdom.sheremetyevo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Data
public class UserDto {

    private Long id;

    @NotNull
    private String login;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotEmpty
    private String name;

    @NotEmpty
    private String surname;

    @NotEmpty
    private String patronymic;

    @NotEmpty
    private String phone;

    @NotEmpty
    private String post;

    private List<RoleDto> roles;

}
