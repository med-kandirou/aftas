package com.mkandirou.aftas.fish;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class FishDTOreq {
    @NotNull(message = "name is required")
    private String name;
    @Min(value =1 ,message = "averageWeight is grether than 1")
    private Double averageWeight;
    @NotNull(message = "level_id is required")
    private Integer level_id;
}
