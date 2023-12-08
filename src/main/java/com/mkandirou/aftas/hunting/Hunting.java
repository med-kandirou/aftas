package com.mkandirou.aftas.hunting;

import com.mkandirou.aftas.competition.Competition;
import com.mkandirou.aftas.fish.Fish;
import com.mkandirou.aftas.member.Member;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class Hunting {
    @Id
    private Integer id;
    private Integer numberOfFish;
    @ManyToOne
    private Fish fish;
    @ManyToOne
    private Member member;
    @ManyToOne
    private Competition competition;
}
