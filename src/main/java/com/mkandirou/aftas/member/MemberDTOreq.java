package com.mkandirou.aftas.member;


import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class MemberDTOreq {
    private Integer num;
    @NotNull(message = "name is required")
    private String name;
    @NotNull(message = "familyName is required")
    private String familyName;
    @NotNull(message = "accessionDate is required")
    private LocalDate accessionDate;
    @NotNull(message = "nationality is required")
    private String nationality;
    @NotNull(message = "IdentityDocument is required")
    private IdentityDocumentType identityDocument;
    @NotNull(message = "IdentityNumber is required")
    private String IdentityNumber;
}
