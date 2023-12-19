package com.mkandirou.aftas.fish;


import com.mkandirou.aftas.Exception.ResourceNotFoundException;
import com.mkandirou.aftas.level.Level;
import com.mkandirou.aftas.level.LevelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FishService implements IFish{

    private final FishRepository fishRepository;
    private final LevelRepository levelRepository;
    private final ModelMapper modelMapper;

    public FishService(FishRepository fishRepository,LevelRepository levelRepository,ModelMapper modelMapper) {
        this.fishRepository=fishRepository;
        this.levelRepository=levelRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public FishDTOres findById(String primarykey) {
        Fish fish = fishRepository.findById(primarykey)
                .orElseThrow(() -> new ResourceNotFoundException("id fish : " + primarykey));
        return modelMapper.map(fish, FishDTOres.class);
    }

    @Override
    public FishDTOres save(FishDTOreq DTOreq) {
        Fish fish= modelMapper.map(DTOreq, Fish.class);
        Level lvl = levelRepository.findById(DTOreq.getLevel_id())
                .orElseThrow(() -> new ResourceNotFoundException("id level : " + DTOreq.getLevel_id()));
        fish.setLevel(lvl);
        return modelMapper.map(fishRepository.save(fish), FishDTOres.class);
    }

    @Override
    public FishDTOres deleteById(String primarykey) {
        Fish fish = fishRepository.findById(primarykey)
                .orElseThrow(() -> new ResourceNotFoundException("id fish : " + primarykey));
        fishRepository.deleteById(primarykey);
        return modelMapper.map(fish, FishDTOres.class);
    }


    @Override
    public FishDTOres update(FishDTOreq DTOreq) {
        Fish fish = fishRepository.findById(DTOreq.getName())
                .orElseThrow(() -> new ResourceNotFoundException("id : " + DTOreq.getName()));
        Level lvl = levelRepository.findById(DTOreq.getLevel_id())
                .orElseThrow(() -> new ResourceNotFoundException("id : " + DTOreq.getName()));
        fish.setAverageWeight(DTOreq.getAverageWeight());
        fish.setLevel(lvl);
        fishRepository.save(fish);
        return modelMapper.map(fish, FishDTOres.class);
    }


    @Override
    public List<FishDTOres> findAll() {
        List<Fish> fishs = fishRepository.findAll();
        return fishs.stream()
                .map(f -> modelMapper.map(f, FishDTOres.class))
                .collect(Collectors.toList());
    }

}
