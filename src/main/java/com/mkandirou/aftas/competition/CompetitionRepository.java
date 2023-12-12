package com.mkandirou.aftas.competition;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;


public interface CompetitionRepository extends JpaRepository<Competition,String> {

    Page<Competition> findByDateBefore(LocalDate date,Pageable pageable);
    Page<Competition> findByDateAfter(LocalDate date,Pageable pageable);
    Page<Competition> findByDateEquals(LocalDate date,Pageable pageable);
}
