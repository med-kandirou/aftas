package com.mkandirou.aftas.competition;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Competition")
public class CompetitionController {
    @Autowired
    private CompetitionService competitionService;

    private CompetitionController(CompetitionService competitionService){
        this.competitionService=competitionService;
    }

    @GetMapping
    public ResponseEntity<List<CompetitionDTOres>> getAll(){
        return new ResponseEntity<>(competitionService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = {"{code}"})
    public ResponseEntity<CompetitionDTOres> findById(@PathVariable String code){
        return new ResponseEntity<>(competitionService.findById(code), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CompetitionDTOres> save(@Valid @RequestBody CompetitionDTOreq CompetitionDTOreq){
        return new ResponseEntity<>(competitionService.save(CompetitionDTOreq), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CompetitionDTOres> update(@Valid @RequestBody CompetitionDTOreq CompetitionDTOreq){
        return new ResponseEntity<>(competitionService.update(CompetitionDTOreq), HttpStatus.OK);
    }

    @DeleteMapping(path = {"{code}"})
    public ResponseEntity<CompetitionDTOres> delete(@PathVariable String code){
        return new ResponseEntity<>(competitionService.deleteById(code), HttpStatus.OK);
    }
}
