package com.mkandirou.aftas.member;


import com.mkandirou.aftas.Exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService implements IMember{
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ModelMapper modelMapper;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository=memberRepository;
    }

    @Override
    public MemberDTOres findById(Integer primarykey) {
        Member member = memberRepository.findById(primarykey)
                .orElseThrow(() -> new ResourceNotFoundException("id Member : " + primarykey));
        return modelMapper.map(member, MemberDTOres.class);
    }

    @Override
    public MemberDTOres save(MemberDTOreq DTOreq) {
        Member Member= modelMapper.map(DTOreq, Member.class);
        return modelMapper.map(memberRepository.save(Member), MemberDTOres.class);
    }

    @Override
    public MemberDTOres deleteById(Integer primarykey) {
        Member Member = memberRepository.findById(primarykey)
                .orElseThrow(() -> new ResourceNotFoundException("id Member : " + primarykey));
        memberRepository.deleteById(primarykey);
        return modelMapper.map(Member, MemberDTOres.class);
    }

    @Override
    public MemberDTOres update(MemberDTOreq DTOreq) {
        Member member = memberRepository.findById(DTOreq.getNum())
                .orElseThrow(() -> new ResourceNotFoundException("id Member: " + DTOreq.getNum()));
        member.setName(DTOreq.getName());
        member.setFamilyName(DTOreq.getFamilyName());
        member.setAccessionDate(DTOreq.getAccessionDate());
        member.setNationality(DTOreq.getNationality());
        member.setIdentityDocument(DTOreq.getIdentityDocument());
        member.setIdentityNumber(DTOreq.getIdentityNumber());
        memberRepository.save(member);
        return modelMapper.map(member, MemberDTOres.class);
    }

    @Override
    public List<MemberDTOres> findAll() {
        List<Member> Members = memberRepository.findAll();
        return Members.stream()
                .map(f -> modelMapper.map(f, MemberDTOres.class))
                .collect(Collectors.toList());
    }


    public List<MemberDTOres> findMembersNotexistInComp(String competitionCode) {
        List<Member> Members = memberRepository.findMembersNotInCompetition(competitionCode);
        return Members.stream()
                .map(member -> modelMapper.map(member, MemberDTOres.class))
                .collect(Collectors.toList());
    }
}
