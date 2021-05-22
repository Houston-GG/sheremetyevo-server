package tech.visdom.sheremetyevo.service;

import org.apache.commons.collections4.IterableUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.visdom.sheremetyevo.dao.RunwayDao;
import tech.visdom.sheremetyevo.dto.RunwayDto;
import tech.visdom.sheremetyevo.model.Runway;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RunwayService {

    private final RunwayDao runwayDao;
    private final ModelMapper modelMapper;

    @Autowired
    public RunwayService(RunwayDao runwayDao, ModelMapper modelMapper) {
        this.runwayDao = runwayDao;
        this.modelMapper = modelMapper;
    }

    public List<Runway> getAllRunwaysEntities() {
        return IterableUtils.toList(runwayDao.findAll());
    }

    public List<RunwayDto> getAllRunwaysDto() {
        return getAllRunwaysEntities()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private RunwayDto convertToDto(Runway runway) {
        return modelMapper.map(runway, RunwayDto.class);
    }
}
