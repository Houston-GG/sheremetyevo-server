package tech.visdom.sheremetyevo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.visdom.sheremetyevo.dto.NewTaskDto;
import tech.visdom.sheremetyevo.dto.TaskDto;
import tech.visdom.sheremetyevo.service.TaskService;
import tech.visdom.sheremetyevo.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    @Autowired
    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping()
    public List<TaskDto> getAllTasksDto(){
        return taskService.getAllTasksDto();
    }

    @PostMapping(value = "/task")
    public void creatNewTask(@Valid @RequestBody List<NewTaskDto> newTaskDto) {
        taskService.createNewTask(newTaskDto, userService.getAuthorizedUserEntity());
    }
}
