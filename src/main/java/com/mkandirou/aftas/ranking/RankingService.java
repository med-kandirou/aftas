package com.mkandirou.aftas.ranking;

import com.mkandirou.aftas.Exception.AddMemberException;
import com.mkandirou.aftas.Exception.ResourceNotFoundException;
import com.mkandirou.aftas.competition.Competition;
import com.mkandirou.aftas.competition.CompetitionRepository;
import com.mkandirou.aftas.hunting.Hunting;
import com.mkandirou.aftas.hunting.HuntingRepository;
import com.mkandirou.aftas.member.Member;
import com.mkandirou.aftas.member.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
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
    private HuntingRepository huntingRepository;
    @Autowired
    private ModelMapper modelMapper;

    public RankingService(RankingRepository rankingRepository,MemberRepository memberRepository, CompetitionRepository competitionRepository,HuntingRepository huntingRepository) {
        this.rankingRepository=rankingRepository;
        this.memberRepository=memberRepository;
        this.competitionRepository=competitionRepository;
        this.huntingRepository=huntingRepository;
    }

    @Override
    public RankingDTOres findById(RankingId primarykey) {
        Ranking ranking = rankingRepository.findById(primarykey)
                .orElseThrow(() -> new ResourceNotFoundException("rankingId : " + primarykey));
        Member member = memberRepository.findById(primarykey.getMember().getNum())
                .orElseThrow(() -> new ResourceNotFoundException("num member: " + primarykey.getMember().getNum()));
        Competition competition = competitionRepository.findById(primarykey.getCompetition().getCode())
                .orElseThrow(() -> new ResourceNotFoundException("code competition: " + primarykey.getCompetition().getCode()));
        RankingId rId=new RankingId();
        rId.setCompetition(competition);
        rId.setMember(member);
        ranking.setRankingId(rId);
        return modelMapper.map(ranking, RankingDTOres.class);
    }

    @Override
    public RankingDTOres save(RankingDTOreq DTOreq) {





        Ranking ranking= modelMapper.map(DTOreq, Ranking.class);
        Member member = memberRepository.findById(DTOreq.getRankingId().getMember().getNum())
                .orElseThrow(() -> new ResourceNotFoundException("num member: " + DTOreq.getRankingId().getMember().getNum()));
        Competition competition = competitionRepository.findById(DTOreq.getRankingId().getCompetition().getCode())
                .orElseThrow(() -> new ResourceNotFoundException("code competition: " + DTOreq.getRankingId().getCompetition().getCode()));
        int comparisonResult = LocalDate.now().compareTo(competition.getDate());
        if(comparisonResult>0){
            throw new AddMemberException("Date not available");
        }
        if(rankingRepository.countRankingsByCompetitionCode(competition.getCode())<competition.getNumberOfParticipants()){
            RankingId rId=new RankingId();
            rId.setCompetition(competition);
            rId.setMember(member);
            ranking.setRankingId(rId);
            rankingRepository.save(ranking);
            return modelMapper.map(ranking, RankingDTOres.class);
        }
        else{
            throw new AddMemberException("the competition is full");
        }
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
        Member member = memberRepository.findById(DTOreq.getRankingId().getMember().getNum())
                .orElseThrow(() -> new ResourceNotFoundException("num member: " + DTOreq.getRankingId().getMember().getNum()));
        Competition competition = competitionRepository.findById(DTOreq.getRankingId().getCompetition().getCode())
                .orElseThrow(() -> new ResourceNotFoundException("code competition: " + DTOreq.getRankingId().getCompetition().getCode()));
        RankingId rId=new RankingId();
        rId.setCompetition(competition);
        rId.setMember(member);
        ranking.setRankingId(rId);
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
        List<Ranking> rankings = rankingRepository.findByRankingId_Competition_Code(code);
        return rankings.stream()
                .map(c -> modelMapper.map(c, RankingDTOres.class))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean calculePointbyCompetition(String code) {
        competitionRepository.findById(code)
                .orElseThrow(() -> new ResourceNotFoundException("code competition: " + code));
        List<Hunting> huntings= huntingRepository.findByCompetitionCode(code);
        int score=0;
        for(Hunting hunt:huntings){
            score+=hunt.getFish().getLevel().getPoints() * hunt.getNumberOfFish();
            RankingId rankingId= new RankingId();
            rankingId.setCompetition(hunt.getCompetition());
            rankingId.setMember(hunt.getMember());
            Ranking ranking=rankingRepository.findById(rankingId)
                    .orElseThrow(() -> new ResourceNotFoundException("renkingId: " + rankingId));
            ranking.setScore(ranking.getScore()+score);
            rankingRepository.save(ranking);
            score=0;
        }
        List<Ranking> sortedRankings = rankingRepository.findByRankingId_Competition_Code(code)
                .stream()
                .sorted(Comparator.comparingInt(Ranking::getScore).reversed())
                .toList();
        int rankNumber=1;
        for (Ranking rank: sortedRankings) {
            rank.setRank(rankNumber);
            rankingRepository.save(rank);
            rankNumber++;
        }
        return true;
    }

}
