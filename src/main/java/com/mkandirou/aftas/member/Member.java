package com.mkandirou.aftas.member;

import com.mkandirou.aftas.hunting.Hunting;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table
@NoArgsConstructor
@RequiredArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer num;
    @NonNull private String name;
    @NonNull private String familyName;
    @NonNull private LocalDate accessionDate;
    @NonNull private String nationality;
    @NonNull private IdentityDocumentType IdentityDocument;
    @NonNull
    private String IdentityNumber;

    @OneToMany
    private List<Hunting> huntings;
}
