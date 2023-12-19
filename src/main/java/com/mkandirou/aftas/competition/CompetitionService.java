package com.mkandirou.aftas.competition;

import com.mkandirou.aftas.Exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CompetitionService implements ICompetition{

    private final CompetitionRepository competitionRepository;
    private final ModelMapper modelMapper;

    public CompetitionService(CompetitionRepository competitionRepository, ModelMapper modelMapper) {
        this.competitionRepository=competitionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CompetitionDTOres findById(String primarykey) {
        Competition competition = competitionRepository.findById(primarykey)
                .orElseThrow(() -> new ResourceNotFoundException("id Member : " + primarykey));
        return modelMapper.map(competition, CompetitionDTOres.class);
    }

    @Override
    public CompetitionDTOres save(CompetitionDTOreq DTOreq) {
        DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yy");
        Competition competition= modelMapper.map(DTOreq, Competition.class);
        String formattedDate = competition.getDate().format(DATE_FORMATTER);
        competition.setCode(competition.getLocation().substring(0, Math.min(competition.getLocation().length(), 3)) + "-" + formattedDate);
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
    public Page<CompetitionDTOres> findAll(String status, Pageable pageable) {
        Page<Competition> competitions=null;
        if ("old".equals(status)) {
            competitions = competitionRepository.findByDateBefore(LocalDate.now(),pageable);
        } else if ("pending".equals(status)) {
            competitions = competitionRepository.findByDateEquals(LocalDate.now(),pageable);
        } else {
            competitions = competitionRepository.findByDateAfter(LocalDate.now(),pageable);
        }
        return competitions.map(c -> modelMapper.map(c, CompetitionDTOres.class));
    }
}
