package com.mkandirou.aftas.level;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LevelConfig {
    @Bean
    CommandLineRunner commandLineRunnerLevel(LevelRepository repository){
        return args -> {

        };
    }
}