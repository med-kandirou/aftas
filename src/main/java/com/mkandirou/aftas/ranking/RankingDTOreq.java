package com.mkandirou.aftas.ranking;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RankingDTOreq {
    @NotNull(message = "rankingId is required")
    private RankingId rankingId;
    @Min(value=0,message = "rank invalid")
    private Integer rank;
    @NotNull(message = "score is required")
    private Integer score;
    @NotNull(message = "member_num is required")
    private Integer member_num;
    @NotNull(message = "competition_code is required")
    private String competition_code;
}
