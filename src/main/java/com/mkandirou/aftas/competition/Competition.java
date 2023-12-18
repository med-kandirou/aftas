package com.mkandirou.aftas.competition;

import com.mkandirou.aftas.hunting.Hunting;
import com.mkandirou.aftas.ranking.Ranking;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


@Data
@Entity
@Table
@NoArgsConstructor
@RequiredArgsConstructor
public class Competition {
    @Id
    @NonNull private String code;
    @NonNull private LocalDate date;
    @NonNull private LocalTime startTime;
    @NonNull private LocalTime endTime;
    @NonNull private Integer numberOfParticipants;
    @NonNull private String location;
    @NonNull private Double amount;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Hunting> huntings;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Ranking> rankings;
}
