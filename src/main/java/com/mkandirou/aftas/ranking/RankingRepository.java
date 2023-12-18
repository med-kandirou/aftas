package com.mkandirou.aftas.ranking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RankingRepository extends JpaRepository<Ranking,RankingId> {
    List<Ranking> findByRankingId_Competition_Code(String competitionCode);

    @Query("SELECT COUNT(r) FROM Ranking r WHERE r.rankingId.competition.code = :competitionCode")
    Integer countRankingsByCompetitionCode(@Param("competitionCode") String competitionCode);

}
