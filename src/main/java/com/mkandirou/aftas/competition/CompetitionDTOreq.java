package com.mkandirou.aftas.competition;


import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class CompetitionDTOreq {
    private String code;
    @NotNull(message = "date is required")
    private LocalDate date;
    @NotNull(message = "startTime is required")
    private LocalTime startTime;
    @NotNull(message = "endTime is required")
    private LocalTime endTime;
    @NotNull(message = "numberOfParticipants is required")
    private Integer numberOfParticipants;
    @NotNull(message = "location is required")
    private String location;
    @Min(value=0,message = "amount is required")
    private Double amount;
}
