package com.hackathon.petvully.service;

import com.hackathon.petvully.dto.PetDTO;
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
    public Pet create(PetDTO petDTO) {
        return petRepository.save(petDTO.toEntity());
    }

    @Transactional
    public Pet findById(long id) {
        Optional<Pet> foundPet = petRepository.findById(id);
        return foundPet.orElse(null);
    }

    @Transactional
    public Pet update(PetDTO petDTO) {
        Pet foundPet = findById(petDTO.getId());
        return petRepository.save(foundPet);
    }

    @Transactional
    public void delete(Pet pet) {
        petRepository.delete(pet);
    }
}
