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
            Level l= new Level("easy",1);
            Level l2= new Level("meduim",2);
            Level l3= new Level("hard",3);
            repository.saveAll(List.of(l,l2,l3));
        };
    }
}