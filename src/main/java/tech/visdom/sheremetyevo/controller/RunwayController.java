package tech.visdom.sheremetyevo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.visdom.sheremetyevo.dto.RunwayDto;
import tech.visdom.sheremetyevo.dto.RunwayUnitReport;
import tech.visdom.sheremetyevo.dto.TechnicWithDistDto;
import tech.visdom.sheremetyevo.service.RunwayService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/runways")
public class RunwayController {

    private final RunwayService runwayService;

    @Autowired
    public RunwayController(RunwayService runwayService) {
        this.runwayService = runwayService;
    }

    @GetMapping()
    public List<RunwayDto> getAllRunwaysDto() {
        return runwayService.getAllRunwaysDto();
    }

    @PutMapping(value = "/units")
    public void updateRunwayUnit(@Valid @RequestBody List<RunwayUnitReport> runwayUnitReports) {
        runwayService.updateRunwayUnit(runwayUnitReports);
    }

    @GetMapping("/way/{id}")
    public List<TechnicWithDistDto> getShortestWay(@PathVariable("id") Long id) {
        return runwayService
                .getBestTechnicsFor(id)
                .entrySet()
                .stream()
                .map(technicDtoLongEntry -> new TechnicWithDistDto(technicDtoLongEntry.getKey(), technicDtoLongEntry.getValue()))
                .collect(Collectors.toList());
    }
}
