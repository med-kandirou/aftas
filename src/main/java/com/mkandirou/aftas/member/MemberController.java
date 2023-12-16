package com.mkandirou.aftas.member;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    private MemberController(MemberService memberService){
        this.memberService=memberService;
    }

    @GetMapping
    public ResponseEntity<List<MemberDTOres>> getAll(){
        return new ResponseEntity<>(memberService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = {"{code}"})
    public ResponseEntity<MemberDTOres> findById(@PathVariable Integer code){
        return new ResponseEntity<>(memberService.findById(code), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MemberDTOres> save(@Valid @RequestBody MemberDTOreq memberDTOreq){
        return new ResponseEntity<>(memberService.save(memberDTOreq), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MemberDTOres> update(@Valid @RequestBody MemberDTOreq memberDTOreq){
        return new ResponseEntity<>(memberService.update(memberDTOreq), HttpStatus.OK);
    }

    @DeleteMapping(path = {"{num}"})
    public ResponseEntity<MemberDTOres> delete(@PathVariable Integer num){
        return new ResponseEntity<>(memberService.deleteById(num), HttpStatus.OK);
    }

    @GetMapping(path = {"MemberNotExistInComp/{competitionCode}"})
    public ResponseEntity<List<MemberDTOres>> MemberNotExistInComp(@PathVariable String competitionCode){
        return new ResponseEntity<>(memberService.findMembersNotexistInComp(competitionCode), HttpStatus.OK);
    }

    @GetMapping(path = {"find/{competitionCode}/{index}"})
    public ResponseEntity<List<MemberDTOres>> findByNumOrNameOrFamilyName(@PathVariable String index,@PathVariable String competitionCode){
        return new ResponseEntity<>(memberService.findByNumOrNameOrFamilyName(competitionCode,index), HttpStatus.OK);
    }
}
