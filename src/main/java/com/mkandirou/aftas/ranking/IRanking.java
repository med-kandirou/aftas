package com.mkandirou.aftas.ranking;

import com.mkandirou.aftas.helpers.IData;

import java.util.List;

public interface IRanking extends IData<RankingDTOreq,RankingDTOres,RankingId> {
    List<RankingDTOres> findAll();
    List<RankingDTOres> findRankingByCompetitionCode(String code);
    Boolean calculePointbyCompetition(String code);
}
