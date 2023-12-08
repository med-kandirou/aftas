package com.mkandirou.aftas.fish;


import com.mkandirou.aftas.level.Level;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FishDTOres {
    private String name;
    private Double averageWeight;
    private Level level;
}
