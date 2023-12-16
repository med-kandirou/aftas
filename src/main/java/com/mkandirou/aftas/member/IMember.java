package com.mkandirou.aftas.member;

import com.mkandirou.aftas.helpers.IData;

import java.util.List;

public interface IMember extends IData<MemberDTOreq,MemberDTOres,Integer> {
    List<MemberDTOres> findAll();
    List<MemberDTOres> findMembersNotexistInComp(String competitionCode);
    List<MemberDTOres> findByNumOrNameOrFamilyName(String codeComp,String index);
}
