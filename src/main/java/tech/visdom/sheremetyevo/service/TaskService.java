package tech.visdom.sheremetyevo.service;

import org.apache.commons.collections4.IterableUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.visdom.sheremetyevo.dao.TaskDao;
import tech.visdom.sheremetyevo.dto.TaskDto;
import tech.visdom.sheremetyevo.model.Task;

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

    private TaskDto convertToDto(Task task) {
        return modelMapper.map(task, TaskDto.class);
    }
}
