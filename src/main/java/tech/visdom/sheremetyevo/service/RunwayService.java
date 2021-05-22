package tech.visdom.sheremetyevo.service;

import org.apache.commons.collections4.IterableUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.visdom.sheremetyevo.dao.RunwayDao;
import tech.visdom.sheremetyevo.dao.RunwayUnitDao;
import tech.visdom.sheremetyevo.dto.RunwayDto;
import tech.visdom.sheremetyevo.dto.RunwayUnitReport;
import tech.visdom.sheremetyevo.dto.TechnicDto;
import tech.visdom.sheremetyevo.exception.RunwayUnitNotFoundException;
import tech.visdom.sheremetyevo.model.Runway;
import tech.visdom.sheremetyevo.model.RunwayUnit;
import tech.visdom.sheremetyevo.model.Technic;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RunwayService {

    private final RunwayDao runwayDao;
    private final ModelMapper modelMapper;
    private final RunwayUnitDao runwayUnitDao;
    private final TechnicService technicService;

    private static final long INF = Integer.MAX_VALUE / 2;

    @Autowired
    public RunwayService(RunwayDao runwayDao, ModelMapper modelMapper, RunwayUnitDao runwayUnitDao, TechnicService technicService) {
        this.runwayDao = runwayDao;
        this.modelMapper = modelMapper;
        this.runwayUnitDao = runwayUnitDao;
        this.technicService = technicService;
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

    public Map<TechnicDto, Long> getBestTechnicsFor(Long id) {
        RunwayUnit unit = runwayUnitDao.findById(id).orElseThrow(() -> new RunwayUnitNotFoundException(id));

        Runway firstRunway = getAllRunwaysEntities().get(0);
        List<List<Long>> graph = firstRunway.getUnits().stream().map(runwayUnit -> {
            List<Long> tmp = new ArrayList<>(Collections.emptyList());
            firstRunway.getUnits().forEach(runwayUnit1 -> {
                if(runwayUnit.equals(runwayUnit1)) {
                    tmp.add(0L);
                } else {
                    tmp.add((runwayUnit.getChilds().contains(runwayUnit1) || runwayUnit1.getChilds().contains(runwayUnit)) ? 1L : INF);
                }
            });
            return tmp;
        }).collect(Collectors.toList());

        ArrayList<Boolean> used = new ArrayList<>(Collections.nCopies(graph.size(), false)); // массив пометок
        ArrayList<Long> dist = new ArrayList<>(Collections.nCopies(graph.size(), INF));
        dist.set(id.intValue() - 1, 0L);
        while (true){
            int v = -1;
            for (int nv = 0; nv < graph.size(); nv++) // перебираем вершины
                if (!used.get(nv) && dist.get(nv) < INF && (v == -1 || dist.get(v) > dist.get(nv))) // выбираем самую близкую непомеченную вершину
                    v = nv;
            if (v == -1) break; // ближайшая вершина не найдена
            used.set(v, true); // помечаем ее
            for (int nv = 0; nv < graph.size(); nv++)
                if (!used.get(nv) && graph.get(v).get(nv) < INF) // для всех непомеченных смежных
                    dist.set(nv,Math.min(dist.get(nv), dist.get(v) + graph.get(v).get(nv))); // улучшаем оценку расстояния (релаксация)
        }

        Long typeId = unit.getIcing() > 0 ? 1L : 2L;

        List<TechnicDto> technicsDto = technicService.getAllFreeTechnicsDtoByType(typeId);

        return technicsDto
                .stream()
                .collect(Collectors.toMap(technicDto -> technicDto, technicDto -> dist.get(technicDto.getRunwayUnit().getId().intValue() - 1)));
    }

    @Transactional
    public void updateRunwayUnit(List<RunwayUnitReport> runwayUnitReports) {
        runwayUnitReports.forEach(e -> runwayUnitDao.updateUnit(e.getId(), e.getIcing(), e.getSnowLevel()));
    }

    private RunwayDto convertToDto(Runway runway) {
        return modelMapper.map(runway, RunwayDto.class);
    }
}
