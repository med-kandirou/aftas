package com.mkandirou.aftas.hunting;

import com.mkandirou.aftas.competition.Competition;
import com.mkandirou.aftas.fish.Fish;
import com.mkandirou.aftas.member.Member;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@Entity
@Table
@NoArgsConstructor
//@RequiredArgsConstructor
public class Hunting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer numberOfFish;
    @ManyToOne
    private Fish fish;
    @ManyToOne
    private Member member;
    @ManyToOne
    private Competition competition;
}
