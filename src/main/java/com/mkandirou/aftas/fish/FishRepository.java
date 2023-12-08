package com.mkandirou.aftas.fish;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FishRepository extends JpaRepository<Fish,String> {

}
