package com.hackathon.petvully.repository;

import com.hackathon.petvully.entity.Pet;
import com.hackathon.petvully.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Long> {

    Pet findByUserId(User user);
}
