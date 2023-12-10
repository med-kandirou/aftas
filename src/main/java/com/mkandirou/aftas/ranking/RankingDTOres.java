package com.mkandirou.aftas.ranking;


import com.mkandirou.aftas.competition.Competition;
import com.mkandirou.aftas.member.Member;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RankingDTOres {
    private RankingId rankingId;
    private Integer rank;
    private Integer score;
    private Member member;
    private Competition competition;
}
