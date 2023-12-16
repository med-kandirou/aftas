package com.mkandirou.aftas.ranking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RankingRepository extends JpaRepository<Ranking,RankingId> {
    List<Ranking> findByRankingId_Competition_Code(String competitionCode);


}
