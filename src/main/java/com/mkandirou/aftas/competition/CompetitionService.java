package com.mkandirou.aftas.competition;

import com.mkandirou.aftas.Exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetitionService implements ICompetition{
    @Autowired
    private CompetitionRepository competitionRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository=competitionRepository;
    }

    @Override
    public CompetitionDTOres findById(String primarykey) {
        Competition competition = competitionRepository.findById(primarykey)
                .orElseThrow(() -> new ResourceNotFoundException("id Member : " + primarykey));
        return modelMapper.map(competition, CompetitionDTOres.class);
    }

    @Override
    public CompetitionDTOres save(CompetitionDTOreq DTOreq) {
        Competition competition= modelMapper.map(DTOreq, Competition.class);
        return modelMapper.map(competitionRepository.save(competition), CompetitionDTOres.class);
    }

    @Override
    public CompetitionDTOres deleteById(String primarykey) {
        Competition competition = competitionRepository.findById(primarykey)
                .orElseThrow(() -> new ResourceNotFoundException("id Member : " + primarykey));
        competitionRepository.deleteById(primarykey);
        return modelMapper.map(competition, CompetitionDTOres.class);
    }

    @Override
    public CompetitionDTOres update(CompetitionDTOreq DTOreq) {
        Competition competition = competitionRepository.findById(DTOreq.getCode())
                .orElseThrow(() -> new ResourceNotFoundException("nom competition: " + DTOreq.getCode()));
        competition.setStartTime(DTOreq.getStartTime());
        competition.setEndTime(DTOreq.getEndTime());
        competition.setLocation(DTOreq.getLocation());
        competition.setDate(DTOreq.getDate());
        competition.setNumberOfParticipants(DTOreq.getNumberOfParticipants());
        competition.setAmount(DTOreq.getAmount());
        competitionRepository.save(competition);
        return modelMapper.map(competition, CompetitionDTOres.class);
    }

    @Override
    public List<CompetitionDTOres> findAll() {
        List<Competition> competitions = competitionRepository.findAll();
        return competitions.stream()
                .map(c -> modelMapper.map(c, CompetitionDTOres.class))
                .collect(Collectors.toList());
    }
}
