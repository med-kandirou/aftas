package com.mkandirou.aftas.competition;

import com.mkandirou.aftas.hunting.Hunting;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Competition {
    @Id
    private String code;
    private LocalDate date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime numberOfParticipants;
    private String location;
    private Double amount;

    @OneToMany
    private List<Hunting> huntings;
}
