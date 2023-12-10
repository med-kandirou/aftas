package com.mkandirou.aftas.level;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api/Level")
public class LevelContoller {
    @Autowired
    private LevelService levelService;

    private LevelContoller(LevelService levelService){
        this.levelService=levelService;
    }

    @GetMapping
    public ResponseEntity<List<LevelDTOres>> getAll(){
        return new ResponseEntity<>(levelService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = {"{code}"})
    public ResponseEntity<LevelDTOres> findById(@PathVariable Integer code){
        return new ResponseEntity<>(levelService.findById(code), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LevelDTOres> save(@Valid @RequestBody LevelDTOreq levelDTOreq){
        return new ResponseEntity<>(levelService.save(levelDTOreq), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<LevelDTOres> update(@Valid @RequestBody LevelDTOreq levelDTOreq){
        return new ResponseEntity<>(levelService.update(levelDTOreq), HttpStatus.OK);
    }

    @DeleteMapping(path = {"{code}"})
    public ResponseEntity<LevelDTOres> delete(@PathVariable Integer code){
        return new ResponseEntity<>(levelService.deleteById(code), HttpStatus.OK);
    }
}
