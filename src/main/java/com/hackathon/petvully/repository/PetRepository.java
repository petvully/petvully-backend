package com.hackathon.petvully.repository;

import com.hackathon.petvully.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {

    Pet findByUserId(long id);
}
