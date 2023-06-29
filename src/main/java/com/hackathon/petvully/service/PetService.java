package com.hackathon.petvully.service;

import com.hackathon.petvully.dto.PetDTO;
import com.hackathon.petvully.entity.Pet;
import com.hackathon.petvully.entity.User;
import com.hackathon.petvully.repository.PetRepository;
import com.hackathon.petvully.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;

    @Autowired
    private final UserRepository userRepository;

    @Transactional
    public Pet create(PetDTO petDTO) {
        User user = userRepository.findByEmail(petDTO.getEmail());
        return petRepository.save(petDTO.toEntity(user));
    }

    @Transactional
    public Pet findById(long id) {
        Optional<Pet> foundPet = petRepository.findById(id);
        return foundPet.orElse(null);
    }

    @Transactional
    public Pet findByUserId(long id) {
        return petRepository.findByUserId(id);
    }

    @Transactional
    public Pet update(PetDTO petDTO) {
        Pet foundPet = findByUserId(userRepository.findByEmail(petDTO.getEmail()).getId());
        return petRepository.save(foundPet);
    }

    @Transactional
    public void delete(Pet pet) {
        petRepository.delete(pet);
    }
}
