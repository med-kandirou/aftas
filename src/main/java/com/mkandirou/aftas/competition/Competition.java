package com.mkandirou.aftas.competition;

import com.mkandirou.aftas.hunting.Hunting;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
@Table
@NoArgsConstructor
//@RequiredArgsConstructor
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
