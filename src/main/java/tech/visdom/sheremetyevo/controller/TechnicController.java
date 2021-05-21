package tech.visdom.sheremetyevo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.visdom.sheremetyevo.dto.TechnicDto;
import tech.visdom.sheremetyevo.service.TechnicService;

import java.util.List;

@RestController
@RequestMapping(value = "/technics")
public class TechnicController {

    private final TechnicService technicService;

    @Autowired
    public TechnicController(TechnicService technicService) {
        this.technicService = technicService;
    }

    @GetMapping()
    public List<TechnicDto> getAllTechnicsDto(){
        return technicService.getAllTechnicsDto();
    }
}
