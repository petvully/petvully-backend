package com.hackathon.petvully.service;

import com.hackathon.petvully.dto.PetDTO.PetSaveDTO;
import com.hackathon.petvully.entity.Pet;
import com.hackathon.petvully.entity.User;
import com.hackathon.petvully.repository.PetRepository;
import com.hackathon.petvully.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    private final UserRepository userRepository;

    public String create(PetSaveDTO petSaveDTO) {
        User user = userRepository.findById(petSaveDTO.getUserId()).orElseThrow();
        petRepository.save(petSaveDTO.toEntity(user));
        return "생성";
    }

    public List<Pet> info() {
        return petRepository.findAll();
    }

    public Optional<Pet> infodetail(Long pet_id) {
        return petRepository.findById(pet_id);
    }

    public Optional<Pet> mypet(Long user_id) {
        return petRepository.findByUserId(user_id);
    }
}
