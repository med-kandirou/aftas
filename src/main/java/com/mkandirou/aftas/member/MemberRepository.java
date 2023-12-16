package com.mkandirou.aftas.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Integer> {

    @Query("SELECT m FROM Member m WHERE m NOT IN " +
            "(SELECT r.rankingId.member FROM Ranking r WHERE r.rankingId.competition.code = :competitionCode)")
    List<Member> findMembersNotInCompetition(@Param("competitionCode") String competitionCode);
}
