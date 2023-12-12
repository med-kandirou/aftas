package com.mkandirou.aftas.ranking;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RankingRepository extends JpaRepository<Ranking,RankingId> {
    List<Ranking> findRankingByCompetitionCode(String code);
}
