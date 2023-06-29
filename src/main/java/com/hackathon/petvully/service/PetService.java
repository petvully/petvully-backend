package com.hackathon.petvully.service;

import com.hackathon.petvully.entity.Pet;
import com.hackathon.petvully.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;

    @Transactional
    public Pet findById(long id) {
        Optional<Pet> foundPet = petRepository.findById(id);
        return foundPet.orElse(null);
    }
}
