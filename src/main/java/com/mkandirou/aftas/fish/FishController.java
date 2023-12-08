package com.mkandirou.aftas.fish;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api/Fish")
public class FishController {
    @Autowired
    private FishService fishService;

    private FishController(FishService fishService){
        this.fishService=fishService;
    }

    @GetMapping
    public ResponseEntity<List<FishDTOres>> getAll(){
        return new ResponseEntity<>(fishService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = {"{name}"})
    public ResponseEntity<FishDTOres> findById(@PathVariable String name){
        return new ResponseEntity<>(fishService.findById(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FishDTOres> save(@Valid @RequestBody FishDTOreq fishDTOreq){
        return new ResponseEntity<>(fishService.save(fishDTOreq), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<FishDTOres> update(@Valid @RequestBody FishDTOreq fishDTOreq){
        return new ResponseEntity<>(fishService.update(fishDTOreq), HttpStatus.OK);
    }

    @DeleteMapping(path = {"{name}"})
    public ResponseEntity<FishDTOres> delete(@PathVariable String name){
        return new ResponseEntity<>(fishService.deleteById(name), HttpStatus.OK);
    }
}
