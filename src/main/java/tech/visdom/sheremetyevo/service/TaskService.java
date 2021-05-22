package tech.visdom.sheremetyevo.service;

import org.apache.commons.collections4.IterableUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.visdom.sheremetyevo.dao.TaskDao;
import tech.visdom.sheremetyevo.dto.NewTaskDto;
import tech.visdom.sheremetyevo.dto.TaskDto;
import tech.visdom.sheremetyevo.model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskDao taskDao;
    private final ModelMapper modelMapper;

    @Autowired
    public TaskService(TaskDao taskDao, ModelMapper modelMapper) {
        this.taskDao = taskDao;
        this.modelMapper = modelMapper;
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

    public void createNewTask(List<NewTaskDto> tasks, User operator) {
        Task task = new Task(LocalDateTime.now(), LocalDateTime.now().plusMinutes(tasks.size() + 5L), operator, 1L);
        List<TaskUnit> taskUnits = new ArrayList<>();

        tasks.forEach(e -> e.getTechnicIds().forEach(t-> taskUnits.add(new TaskUnit(task, new RunwayUnit(e.getRunwayUnitId()), new Technic(t), false))));
        task.setTaskUnits(taskUnits);
        taskDao.save(task);
    }

    private TaskDto convertToDto(Task task) {
        return modelMapper.map(task, TaskDto.class);
    }
}
