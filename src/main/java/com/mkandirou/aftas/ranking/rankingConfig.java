package com.mkandirou.aftas.ranking;

import com.mkandirou.aftas.member.IdentityDocumentType;
import com.mkandirou.aftas.member.Member;
import com.mkandirou.aftas.member.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class rankingConfig {
    @Bean
    CommandLineRunner commandLineRunnerMember(MemberRepository memberRepository) {
        return args -> {
            Member m1 = new Member("John", "Doe", LocalDate.now(), "US", IdentityDocumentType.PASSPORT, "AB123456");
            Member m2 = new Member("Alice", "Smith", LocalDate.now(), "UK", IdentityDocumentType.CARTE_RESIDENCE, "CD789012");
            Member m3 = new Member("Bob", "Johnson", LocalDate.now(), "Canada", IdentityDocumentType.CARTE_RESIDENCE, "EF345678");
            Member m4 = new Member("Eva", "Miller", LocalDate.now(), "Germany", IdentityDocumentType.PASSPORT, "GH901234");
            Member m5 = new Member("mohamed", "kandirou", LocalDate.now(), "France", IdentityDocumentType.CIN, "IJ567890");
            Member m6 = new Member("amine", "hatim", LocalDate.now(), "France", IdentityDocumentType.CIN, "IJ567890");
            Member m7 = new Member("oussama", "haddi", LocalDate.now(), "France", IdentityDocumentType.CIN, "IJ567890");
            Member m8 = new Member("marouane", "ait lhaj", LocalDate.now(), "France", IdentityDocumentType.CIN, "IJ567890");
            Member m9 = new Member("abdelah", "bouzhar", LocalDate.now(), "France", IdentityDocumentType.CIN, "IJ567890");
            memberRepository.saveAll(List.of(m1,m2,m3,m4,m5,m6,m7,m8,m9));
        };
    }
}
