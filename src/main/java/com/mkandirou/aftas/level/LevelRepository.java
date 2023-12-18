package com.mkandirou.aftas.level;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LevelRepository extends JpaRepository<Level,Integer> {
    Optional<Level> findFirstByCodeAfter(int code);
    Optional<Level> findFirstOneByCodeBefore(int code);
}
