package com.mkandirou.aftas.ranking;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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
}
