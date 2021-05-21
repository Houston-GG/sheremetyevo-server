package tech.visdom.sheremetyevo.service;

import org.apache.commons.collections4.IterableUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.visdom.sheremetyevo.dao.TechnicDao;
import tech.visdom.sheremetyevo.dto.TechnicDto;
import tech.visdom.sheremetyevo.model.Technic;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TechnicService {

    private final TechnicDao technicDao;
    private final ModelMapper modelMapper;

    @Autowired
    public TechnicService(TechnicDao technicDao, ModelMapper modelMapper) {
        this.technicDao = technicDao;
        this.modelMapper = modelMapper;
    }

    public List<Technic> getAllTechnicsEntities() {
        return IterableUtils.toList(technicDao.findAll());
    }

    public List<TechnicDto> getAllTechnicsDto() {
        return getAllTechnicsEntities()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private TechnicDto convertToDto(Technic technic) {
        return modelMapper.map(technic, TechnicDto.class);
    }
}
