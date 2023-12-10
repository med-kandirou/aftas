package com.mkandirou.aftas.competition;


import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CompetitionDTOreq {
    @NotNull(message = "code is required")
    private String code;
    @NotNull(message = "date is required")
    private LocalDate date;
    @NotNull(message = "startTime is required")
    private LocalDateTime startTime;
    @NotNull(message = "endTime is required")
    private LocalDateTime endTime;
    @NotNull(message = "numberOfParticipants is required")
    private Integer numberOfParticipants;
    @NotNull(message = "location is required")
    private String location;
    @Min(value=0,message = "amount is required")
    private Double amount;
}
