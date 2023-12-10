package com.mkandirou.aftas.level;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LevelDTOreq {
    private Integer code;
    @NotNull(message = "decription is required")
    @NotNull private String decription;
    @Min(value = 0,message = "points is required to be greather than 0")
    @NotNull private Integer points;
}
