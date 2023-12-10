package com.mkandirou.aftas.member;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class MemberDTOres {
    private Integer num;
    private String name;
    private String familyName;
    private LocalDate accessionDate;
    private String nationality;
    private IdentityDocumentType IdentityDocument;
    private String IdentityNumber;
}
