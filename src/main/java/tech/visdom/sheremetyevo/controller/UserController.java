package tech.visdom.sheremetyevo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.visdom.sheremetyevo.dto.UserDto;
import tech.visdom.sheremetyevo.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user")
    public UserDto getAuthorizedUserDto(){
        return userService.getAuthorizedUserDto();
    }
}
