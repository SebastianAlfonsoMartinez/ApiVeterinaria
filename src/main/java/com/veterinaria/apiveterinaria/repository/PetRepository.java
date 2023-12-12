package com.veterinaria.apiveterinaria.repository;

import com.veterinaria.apiveterinaria.domain.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {
}
