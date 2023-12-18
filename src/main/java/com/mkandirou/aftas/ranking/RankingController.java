package com.mkandirou.aftas.ranking;


import com.mkandirou.aftas.competition.Competition;
import com.mkandirou.aftas.member.Member;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Ranking")
public class RankingController {
    @Autowired
    private RankingService rankingService;

    private RankingController(RankingService rankingService){
        this.rankingService=rankingService;
    }

    @GetMapping
    public ResponseEntity<List<RankingDTOres>> getAll(){
        return new ResponseEntity<>(rankingService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = {"/byCompetition/{code}"})
    public ResponseEntity<List<RankingDTOres>> findRankingByCompetitionCode(@PathVariable String code){
        return new ResponseEntity<>(rankingService.findRankingByCompetitionCode(code), HttpStatus.OK);
    }

    @GetMapping("/{memberId}/{competitionCode}")
    public ResponseEntity<RankingDTOres> findById(@PathVariable Integer memberId, @PathVariable String competitionCode){
        RankingId rankingId = new RankingId();
        Member member = new Member();
        member.setNum(memberId);
        rankingId.setMember(member);
        Competition competition = new Competition();
        competition.setCode(competitionCode);
        rankingId.setCompetition(competition);
        return new ResponseEntity<>(rankingService.findById(rankingId), HttpStatus.OK);
    }

    @DeleteMapping("/{memberId}/{competitionCode}")
    public ResponseEntity<RankingDTOres> delete(@PathVariable Integer memberId, @PathVariable String competitionCode){
        RankingId rankingId = new RankingId();
        Member member = new Member();
        member.setNum(memberId);
        rankingId.setMember(member);
        Competition competition = new Competition();
        competition.setCode(competitionCode);
        rankingId.setCompetition(competition);
        return new ResponseEntity<>(rankingService.deleteById(rankingId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RankingDTOres> save(@Valid @RequestBody RankingDTOreq RankingDTOreq){
        return new ResponseEntity<>(rankingService.save(RankingDTOreq), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<RankingDTOres> update(@Valid @RequestBody RankingDTOreq RankingDTOreq){
        return new ResponseEntity<>(rankingService.update(RankingDTOreq), HttpStatus.OK);
    }



    @GetMapping("/calcule/{code}")
    public ResponseEntity<Boolean> calcule(@PathVariable String code){
        return new ResponseEntity<>(rankingService.calculePointbyCompetition(code), HttpStatus.OK);
    }



}
