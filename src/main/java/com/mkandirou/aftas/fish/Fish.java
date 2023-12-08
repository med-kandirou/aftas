package com.mkandirou.aftas.fish;


import com.mkandirou.aftas.hunting.Hunting;
import com.mkandirou.aftas.level.Level;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Fish {
    @Id
    private String name;
    private Double averageWeight;
    @ManyToOne
    private Level level;

    @OneToMany
    private List<Hunting> huntings;
}
