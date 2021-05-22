package tech.visdom.sheremetyevo.service;

import org.apache.commons.collections4.IterableUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.visdom.sheremetyevo.dao.RunwayDao;
import tech.visdom.sheremetyevo.dao.RunwayUnitDao;
import tech.visdom.sheremetyevo.dto.RunwayDto;
import tech.visdom.sheremetyevo.dto.RunwayUnitReport;
import tech.visdom.sheremetyevo.model.Runway;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RunwayService {

    private final RunwayDao runwayDao;
    private final ModelMapper modelMapper;
    private final RunwayUnitDao runwayUnitDao;

    @Autowired
    public RunwayService(RunwayDao runwayDao, ModelMapper modelMapper, RunwayUnitDao runwayUnitDao) {
        this.runwayDao = runwayDao;
        this.modelMapper = modelMapper;
        this.runwayUnitDao = runwayUnitDao;
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

    @Transactional
    public void updateRunwayUnit(List<RunwayUnitReport> runwayUnitReports) {
        runwayUnitReports.forEach(e -> runwayUnitDao.updateUnit(e.getId(), e.getIcing(), e.getSnowLevel()));
    }

    private RunwayDto convertToDto(Runway runway) {
        return modelMapper.map(runway, RunwayDto.class);
    }
}
