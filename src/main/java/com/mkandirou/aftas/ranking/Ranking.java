package com.mkandirou.aftas.ranking;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Ranking {
    @EmbeddedId
    @NonNull
    private RankingId rankingId;
    @NonNull private Integer rank;
    @NonNull private Integer score;
}
