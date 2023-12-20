package com.mkandirou.aftas.ranking;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class rankingConfig {
    @Bean
    CommandLineRunner commandLineRunnerRanking(RankingRepository rankingRepository) {
        return args -> {

        };
    }
}
