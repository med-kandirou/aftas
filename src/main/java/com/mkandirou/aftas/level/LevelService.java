package com.mkandirou.aftas.level;

import com.mkandirou.aftas.Exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LevelService implements ILevel{
    @Autowired
    private LevelRepository levelRepository;

    @Autowired
    private ModelMapper modelMapper;

    public LevelService(LevelRepository levelRepository) {
        this.levelRepository=levelRepository;
    }

    @Override
    public LevelDTOres findById(Integer primarykey) {
        Level Level = levelRepository.findById(primarykey)
                .orElseThrow(() -> new ResourceNotFoundException("id Level : " + primarykey));
        return modelMapper.map(Level, LevelDTOres.class);
    }

    @Override
    public LevelDTOres save(LevelDTOreq DTOreq) {
        Level Level= modelMapper.map(DTOreq, Level.class);
        return modelMapper.map(levelRepository.save(Level), LevelDTOres.class);
    }

    @Override
    public LevelDTOres deleteById(Integer primarykey) {
        Level Level = levelRepository.findById(primarykey)
                .orElseThrow(() -> new ResourceNotFoundException("id Level : " + primarykey));
        levelRepository.deleteById(primarykey);
        return modelMapper.map(Level, LevelDTOres.class);
    }

    @Override
    public LevelDTOres update(LevelDTOreq DTOreq) {
        Level level = levelRepository.findById(DTOreq.getCode())
                .orElseThrow(() -> new ResourceNotFoundException("id level: " + DTOreq.getCode()));
        level.setPoints(DTOreq.getPoints());
        level.setDecription(DTOreq.getDecription());
        levelRepository.save(level);
        return modelMapper.map(level, LevelDTOres.class);
    }

    @Override
    public List<LevelDTOres> findAll() {
        List<Level> Levels = levelRepository.findAll();
        return Levels.stream()
                .map(f -> modelMapper.map(f, LevelDTOres.class))
                .collect(Collectors.toList());
    }
}
