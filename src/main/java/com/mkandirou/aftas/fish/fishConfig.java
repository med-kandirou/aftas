package com.mkandirou.aftas.fish;

import com.mkandirou.aftas.level.Level;
import com.mkandirou.aftas.level.LevelRepository;
import com.mkandirou.aftas.member.IdentityDocumentType;
import com.mkandirou.aftas.member.Member;
import com.mkandirou.aftas.member.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class fishConfig {
    @Bean
    CommandLineRunner commandLineRunnerFish(LevelRepository levelRepository, FishRepository fishRepository) {
        return args -> {
            Level level1 = new Level(1,"level 1",1);
            Level level2 = new Level(2,"level 2",2);
            Level level3 = new Level(3,"level 3",3);
            levelRepository.saveAll(List.of(level1,level2,level3));

            Fish fish1 = new Fish("Trout", 2.5, level1);
            Fish fish2 = new Fish("Salmon", 3.0, level2);
            Fish fish3 = new Fish("shark", 3.0, level3);
            Fish fish4 = new Fish("calamare", 3.0, level2);
            fishRepository.saveAll(List.of(fish1,fish2,fish3,fish4));
        };
    }
}
