package com.hackathon.petvully.repository;

import com.hackathon.petvully.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Long> {

    Optional<Pet> findByUserId(Long user_id);
}
