package com.mkandirou.aftas.hunting;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HuntingDTOreq {
    private Integer id;
    @Min(value=1,message = "numberOfFish is not valid")
    private Integer numberOfFish;
    @NotNull(message = "fish_name is required")
    private String fish_name;
    @NotNull(message = "member_id is required")
    private Integer member_id;
    @NotNull(message = "competition_code is required")
    private String competition_code;
}
