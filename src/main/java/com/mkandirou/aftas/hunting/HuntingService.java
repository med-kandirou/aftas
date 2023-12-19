package com.mkandirou.aftas.hunting;

import com.mkandirou.aftas.Exception.ResourceNotFoundException;

import com.mkandirou.aftas.competition.Competition;
import com.mkandirou.aftas.competition.CompetitionRepository;
import com.mkandirou.aftas.fish.Fish;
import com.mkandirou.aftas.fish.FishRepository;
import com.mkandirou.aftas.member.Member;
import com.mkandirou.aftas.member.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class HuntingService implements IHunting{

    private final HuntingRepository huntingRepository;
    private final FishRepository fishRepository;
    private final MemberRepository memberRepository;
    private final CompetitionRepository competitionRepository;

    private final ModelMapper modelMapper;

    public HuntingService(HuntingRepository huntingRepository, FishRepository fishRepository, MemberRepository memberRepository, CompetitionRepository competitionRepository,ModelMapper modelMapper) {
        this.huntingRepository=huntingRepository;
        this.fishRepository=fishRepository;
        this.memberRepository=memberRepository;
        this.competitionRepository=competitionRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public HuntingDTOres findById(Integer primarykey) {
        Hunting Hunting = huntingRepository.findById(primarykey)
                .orElseThrow(() -> new ResourceNotFoundException("id Member : " + primarykey));
        return modelMapper.map(Hunting, HuntingDTOres.class);
    }

    @Override
    public HuntingDTOres save(HuntingDTOreq DTOreq) {
        Hunting existHunting = huntingRepository
                .findByCompetitionCodeAndMemberNumAndFishName(
                        DTOreq.getCompetition_code(),
                        DTOreq.getMember_id(),
                        DTOreq.getFish_name()
                );
        if(existHunting!=null){
            existHunting.setNumberOfFish(existHunting.getNumberOfFish()+DTOreq.getNumberOfFish());
            huntingRepository.save(existHunting);
            return modelMapper.map(existHunting, HuntingDTOres.class);
        }
        else{
            Hunting hunting= modelMapper.map(DTOreq, Hunting.class);
            Fish fish = fishRepository.findById(DTOreq.getFish_name())
                    .orElseThrow(() -> new ResourceNotFoundException("name fish: " + DTOreq.getFish_name()));
            Member member = memberRepository.findById(DTOreq.getMember_id())
                    .orElseThrow(() -> new ResourceNotFoundException("name member: " + DTOreq.getMember_id()));
            Competition competition = competitionRepository.findById(DTOreq.getCompetition_code())
                    .orElseThrow(() -> new ResourceNotFoundException("code competition: " + DTOreq.getCompetition_code()));
            hunting.setFish(fish);
            hunting.setCompetition(competition);
            hunting.setMember(member);
            huntingRepository.save(hunting);
            return modelMapper.map(hunting, HuntingDTOres.class);
        }
    }

    @Override
    public HuntingDTOres deleteById(Integer primarykey) {
        Hunting Hunting = huntingRepository.findById(primarykey)
                .orElseThrow(() -> new ResourceNotFoundException("id Member : " + primarykey));
        huntingRepository.deleteById(primarykey);
        return modelMapper.map(Hunting, HuntingDTOres.class);
    }


    @Override
    public HuntingDTOres update(HuntingDTOreq DTOreq) {
        Hunting hunting = huntingRepository.findById(DTOreq.getId())
                .orElseThrow(() -> new ResourceNotFoundException("id hunting: " + DTOreq.getId()));
        Fish fish = fishRepository.findById(DTOreq.getFish_name())
                .orElseThrow(() -> new ResourceNotFoundException("name fish: " + DTOreq.getFish_name()));
        Member member = memberRepository.findById(DTOreq.getMember_id())
                .orElseThrow(() -> new ResourceNotFoundException("name member: " + DTOreq.getMember_id()));
        Competition competition = competitionRepository.findById(DTOreq.getCompetition_code())
                .orElseThrow(() -> new ResourceNotFoundException("code competition: " + DTOreq.getCompetition_code()));
        hunting.setFish(fish);
        hunting.setCompetition(competition);
        hunting.setMember(member);
        hunting.setNumberOfFish(DTOreq.getNumberOfFish());
        huntingRepository.save(hunting);
        return modelMapper.map(hunting, HuntingDTOres.class);
    }

    @Override
    public List<HuntingDTOres> findAll() {
        List<Hunting> Huntings = huntingRepository.findAll();
        return Huntings.stream()
                .map(c -> modelMapper.map(c, HuntingDTOres.class))
                .collect(Collectors.toList());
    }

}
