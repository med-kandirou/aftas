package com.mkandirou.aftas.hunting;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface HuntingRepository extends JpaRepository<Hunting,Integer> {
    Hunting findByCompetitionCodeAndMemberNumAndFishName(String competitionCode, int memberNum, String fishName);
    List<Hunting> findByCompetitionCode(String competitionCode);
}
