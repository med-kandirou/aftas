package com.mkandirou.aftas.ranking;

import com.mkandirou.aftas.Exception.ResourceNotFoundException;
import com.mkandirou.aftas.competition.Competition;
import com.mkandirou.aftas.competition.CompetitionRepository;
import com.mkandirou.aftas.fish.FishRepository;
import com.mkandirou.aftas.member.Member;
import com.mkandirou.aftas.member.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RankingService implements IRanking{

    @Autowired
    private RankingRepository rankingRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private CompetitionRepository competitionRepository;

    @Autowired
    private ModelMapper modelMapper;

    public RankingService(RankingRepository rankingRepository,MemberRepository memberRepository, CompetitionRepository competitionRepository) {
        this.rankingRepository=rankingRepository;
        this.memberRepository=memberRepository;
        this.competitionRepository=competitionRepository;
    }

    @Override
    public RankingDTOres findById(RankingId primarykey) {
        Ranking ranking = rankingRepository.findById(primarykey)
                .orElseThrow(() -> new ResourceNotFoundException("num Member : " + primarykey));
        return modelMapper.map(ranking, RankingDTOres.class);
    }

    @Override
    public RankingDTOres save(RankingDTOreq DTOreq) {
        Ranking ranking= modelMapper.map(DTOreq, Ranking.class);
        Member member = memberRepository.findById(DTOreq.getMember_num())
                .orElseThrow(() -> new ResourceNotFoundException("num member: " + DTOreq.getMember_num()));
        Competition competition = competitionRepository.findById(DTOreq.getCompetition_code())
                .orElseThrow(() -> new ResourceNotFoundException("code competition: " + DTOreq.getCompetition_code()));
        ranking.setCompetition(competition);
        ranking.setMember(member);
        rankingRepository.save(ranking);
        return modelMapper.map(ranking, RankingDTOres.class);
    }

    @Override
    public RankingDTOres deleteById(RankingId primarykey) {
        Ranking ranking = rankingRepository.findById(primarykey)
                .orElseThrow(() -> new ResourceNotFoundException("id Member : " + primarykey));
        rankingRepository.deleteById(primarykey);
        return modelMapper.map(ranking, RankingDTOres.class);
    }

    @Override
    public RankingDTOres update(RankingDTOreq DTOreq) {
        Ranking ranking = rankingRepository.findById(DTOreq.getRankingId())
                .orElseThrow(() -> new ResourceNotFoundException("id Ranking: " + DTOreq.getRankingId()));
        Member member = memberRepository.findById(DTOreq.getMember_num())
                .orElseThrow(() -> new ResourceNotFoundException("name member: " + DTOreq.getMember_num()));
        Competition competition = competitionRepository.findById(DTOreq.getCompetition_code())
                .orElseThrow(() -> new ResourceNotFoundException("code competition: " + DTOreq.getCompetition_code()));
        ranking.setCompetition(competition);
        ranking.setMember(member);
        rankingRepository.save(ranking);
        return modelMapper.map(ranking, RankingDTOres.class);
    }

    @Override
    public List<RankingDTOres> findAll() {
        List<Ranking> rankings = rankingRepository.findAll();
        return rankings.stream()
                .map(c -> modelMapper.map(c, RankingDTOres.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<RankingDTOres> findRankingByCompetitionCode(String code) {
        competitionRepository.findById(code)
                .orElseThrow(() -> new ResourceNotFoundException("code competition: " + code));
        List<Ranking> rankings = rankingRepository.findRankingByCompetitionCode(code);
        return rankings.stream()
                .map(c -> modelMapper.map(c, RankingDTOres.class))
                .collect(Collectors.toList());
    }
}
