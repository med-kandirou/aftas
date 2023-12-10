package com.mkandirou.aftas.ranking;

import com.mkandirou.aftas.competition.Competition;
import com.mkandirou.aftas.member.Member;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Ranking {
    @EmbeddedId
    private RankingId rankingId;
    private Integer rank;
    private Integer score;
    @ManyToOne
    @MapsId("member")
    private Member member;
    @ManyToOne
    @MapsId("competition")
    private Competition competition;
}
