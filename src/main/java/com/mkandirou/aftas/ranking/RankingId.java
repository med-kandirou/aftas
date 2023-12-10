package com.mkandirou.aftas.ranking;


import com.mkandirou.aftas.competition.Competition;
import com.mkandirou.aftas.member.Member;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class RankingId implements Serializable {

    @ManyToOne
    private Member member;
    @ManyToOne
    private Competition competition;
}
