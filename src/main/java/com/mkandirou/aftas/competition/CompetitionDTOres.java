package com.mkandirou.aftas.competition;


import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CompetitionDTOres {
    private String code;
    private LocalDate date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer numberOfParticipants;
    private String location;
    private Double amount;
}
