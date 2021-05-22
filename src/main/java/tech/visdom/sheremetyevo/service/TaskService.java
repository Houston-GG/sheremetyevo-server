package tech.visdom.sheremetyevo.service;

import org.apache.commons.collections4.IterableUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.visdom.sheremetyevo.dao.TaskDao;
import tech.visdom.sheremetyevo.dao.TaskUnitDao;
import tech.visdom.sheremetyevo.dao.UserDao;
import tech.visdom.sheremetyevo.dto.NewTaskDto;
import tech.visdom.sheremetyevo.dto.TaskDto;
import tech.visdom.sheremetyevo.dto.TaskUnitDto;
import tech.visdom.sheremetyevo.exception.UserNotFoundException;
import tech.visdom.sheremetyevo.model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskDao taskDao;
    private final UserDao userDao;
    private final TaskUnitDao taskUnitDao;
    private final ModelMapper modelMapper;

    @Autowired
    public TaskService(TaskDao taskDao, ModelMapper modelMapper, UserDao userDao, TaskUnitDao taskUnitDao) {
        this.taskDao = taskDao;
        this.modelMapper = modelMapper;
        this.userDao = userDao;
        this.taskUnitDao = taskUnitDao;
    }

    public List<Task> getAllTasksEntities() {
        return IterableUtils.toList(taskDao.findAll());
    }

    public List<TaskDto> getAllTasksDto() {
        return getAllTasksEntities()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<TaskUnitDto> getAllTaskUnitsByUserId(Long userId) {
        User user = userDao.findById(userId).orElseThrow(() -> new UserNotFoundException("user with id " + userId + " not found"));
        Set<Technic> technics = user.getTechnics();
        return technics
                .stream()
                .map(technic -> taskUnitDao.findAllByTechnicId(technic.getId()))
                .collect(Collectors.toList())
                .stream()
                .flatMap(taskUnits -> IterableUtils.toList(taskUnits).stream())
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public void createNewTask(List<NewTaskDto> tasks, User operator) {
        Task task = new Task(LocalDateTime.now(), LocalDateTime.now().plusMinutes(tasks.size() + 5L), operator, 1L);
        List<TaskUnit> taskUnits = new ArrayList<>();

        tasks.forEach(e -> e.getTechnicIds().forEach(t-> taskUnits.add(new TaskUnit(task, new RunwayUnit(e.getRunwayUnitId()), new Technic(t), false))));
        task.setTaskUnits(taskUnits);
        taskDao.save(task);
    }

    private TaskUnitDto convertToDto(TaskUnit taskUnit) {
        return modelMapper.map(taskUnit, TaskUnitDto.class);
    }
    private TaskDto convertToDto(Task task) {
        return modelMapper.map(task, TaskDto.class);
    }
}
