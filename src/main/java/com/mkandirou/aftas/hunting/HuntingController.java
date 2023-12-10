package com.mkandirou.aftas.hunting;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Hunting")
public class HuntingController {
    @Autowired
    private HuntingService huntingService;

    private HuntingController(HuntingService huntingService){
        this.huntingService=huntingService;
    }

    @GetMapping
    public ResponseEntity<List<HuntingDTOres>> getAll(){
        return new ResponseEntity<>(huntingService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = {"{id}"})
    public ResponseEntity<HuntingDTOres> findById(@PathVariable Integer id){
        return new ResponseEntity<>(huntingService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HuntingDTOres> save(@Valid @RequestBody HuntingDTOreq huntingDTOreq){
        return new ResponseEntity<>(huntingService.save(huntingDTOreq), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<HuntingDTOres> update(@Valid @RequestBody HuntingDTOreq huntingDTOreq){
        return new ResponseEntity<>(huntingService.update(huntingDTOreq), HttpStatus.OK);
    }

    @DeleteMapping(path = {"{id}"})
    public ResponseEntity<HuntingDTOres> delete(@PathVariable Integer id){
        return new ResponseEntity<>(huntingService.deleteById(id), HttpStatus.OK);
    }
}
