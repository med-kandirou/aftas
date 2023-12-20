package com.mkandirou.aftas.competition;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Configuration
public class competitionConfig {
    @Bean
    CommandLineRunner commandLineRunnerCompetition(CompetitionRepository competitionRepository) {
        return args -> {
            Competition c1 = new Competition("hoc-19-12-23", LocalDate.of(2023,12,18), LocalTime.of(10, 0),
                    LocalTime.of(12, 0), 50, "hoceima", 1000.0);
            Competition c2 = new Competition("jad-19-12-23", LocalDate.of(2023,12,18), LocalTime.of(14, 0),
                    LocalTime.of(16, 0), 30, "jadida", 800.0);
            Competition c3 = new Competition("saf-20-12-23", LocalDate.of(2023,12,20), LocalTime.of(9, 0),
                    LocalTime.of(11, 0), 40, "safi", 1200.0);
            Competition c4 = new Competition("rab-20-12-23", LocalDate.of(2023,12,20), LocalTime.of(13, 0),
                    LocalTime.of(15, 0), 25, "rabat", 900.0);
            Competition c5 = new Competition("aga-20-12-23", LocalDate.of(2023,12,20), LocalTime.of(11, 0),
                    LocalTime.of(13, 0), 60, "agadir", 1500.0);
            Competition c6 = new Competition("tag-23-12-23", LocalDate.of(2023,12,23), LocalTime.of(16, 0),
                    LocalTime.of(18, 0), 45, "taghazout", 1100.0);
            Competition c7 = new Competition("ken-24-12-23", LocalDate.of(2023,12,24), LocalTime.of(8, 0),
                    LocalTime.of(10, 0), 55, "kenitra", 1300.0);


            competitionRepository.saveAll(List.of(c1,c2,c3,c4,c5,c6,c7));
        };
    }
}
