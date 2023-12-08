package com.mkandirou.aftas.member;

import com.mkandirou.aftas.hunting.Hunting;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;


public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer num;
    private String name;
    private String familyName;
    private LocalDate accessionDate;
    private String nationality;
    private IdentityDocumentType IdentityDocument;
    private String IdentityNumber;

    @OneToMany
    private List<Hunting> huntings;
}
