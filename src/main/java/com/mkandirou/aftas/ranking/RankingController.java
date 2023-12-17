package com.mkandirou.aftas.ranking;


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

    /*@GetMapping(path = {"{id}"})
    public ResponseEntity<RankingDTOres> findById(@PathVariable Integer id){
        return new ResponseEntity<>(rankingService.findById(id), HttpStatus.OK);
    }*/

    @PostMapping
    public ResponseEntity<RankingDTOres> save(@Valid @RequestBody RankingDTOreq RankingDTOreq){
        return new ResponseEntity<>(rankingService.save(RankingDTOreq), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<RankingDTOres> update(@Valid @RequestBody RankingDTOreq RankingDTOreq){
        return new ResponseEntity<>(rankingService.update(RankingDTOreq), HttpStatus.OK);
    }

    /*@DeleteMapping(path = {"{id}"})
    public ResponseEntity<RankingDTOres> delete(@PathVariable Integer id){
        return new ResponseEntity<>(rankingService.deleteById(id), HttpStatus.OK);
    }*/

    @GetMapping("/calcule/{code}")
    public ResponseEntity<Boolean> calcule(@PathVariable String code){
        return new ResponseEntity<>(rankingService.calculePointbyCompetition(code), HttpStatus.OK);
    }



}
