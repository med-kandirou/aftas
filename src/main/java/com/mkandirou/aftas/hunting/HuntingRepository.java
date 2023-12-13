package com.mkandirou.aftas.hunting;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HuntingRepository extends JpaRepository<Hunting,Integer> {
    Hunting findByCompetitionCodeAndMemberNumAndFishName(String competitionCode, int memberNum, String fishName);
}
