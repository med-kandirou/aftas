package com.mkandirou.aftas.fish;


import com.mkandirou.aftas.hunting.Hunting;
import com.mkandirou.aftas.level.Level;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Entity
@Table
@NoArgsConstructor
@RequiredArgsConstructor
public class Fish {
    @Id
    @NonNull private String name;
    @NonNull private Double averageWeight;

    @ManyToOne
    @NonNull private Level level;

    @OneToMany
    private List<Hunting> huntings;
}
