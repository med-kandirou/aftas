package com.mkandirou.aftas.hunting;

import com.mkandirou.aftas.competition.Competition;
import com.mkandirou.aftas.fish.Fish;
import com.mkandirou.aftas.member.Member;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@Entity
@Table
@NoArgsConstructor
@RequiredArgsConstructor
public class Hunting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull private Integer numberOfFish;
    @ManyToOne
    @NonNull private Fish fish;
    @ManyToOne
    @NonNull private Member member;
    @ManyToOne
    @NonNull private Competition competition;
}
