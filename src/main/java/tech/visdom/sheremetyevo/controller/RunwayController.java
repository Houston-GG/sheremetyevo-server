package tech.visdom.sheremetyevo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.visdom.sheremetyevo.dto.RunwayDto;
import tech.visdom.sheremetyevo.service.RunwayService;

import java.util.List;

@RestController
@RequestMapping(value = "/runways")
public class RunwayController {

    private final RunwayService runwayService;

    @Autowired
    public RunwayController(RunwayService runwayService) {
        this.runwayService = runwayService;
    }

    @GetMapping()
    public List<RunwayDto> getAllRunwaysDto(){
        return runwayService.getAllRunwaysDto();
    }
}
