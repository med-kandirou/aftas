package com.mkandirou.aftas.competition;

import com.mkandirou.aftas.hunting.Hunting;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @NonNull private LocalDateTime startTime;
    @NonNull private LocalDateTime endTime;
    @NonNull private Integer numberOfParticipants;
    @NonNull private String location;
    @NonNull private Double amount;

    @OneToMany
    private List<Hunting> huntings;
}
