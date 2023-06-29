package com.hackathon.petvully.service;

import com.hackathon.petvully.dto.DonateDTO.DonateSaveDTO;
import com.hackathon.petvully.entity.Donate;
import com.hackathon.petvully.entity.User;
import com.hackathon.petvully.repository.DonateRepository;
import com.hackathon.petvully.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DonateService {

    private final DonateRepository donateRepository;
    private final UserRepository userRepository;

    public ResponseEntity<Donate> register(DonateSaveDTO donateSaveDTO) {
        User user = userRepository.findById(donateSaveDTO.getUserId()).orElseThrow();
        Donate donate = donateRepository.save(donateSaveDTO.toEntity(user));
        return ResponseEntity.ok(donate);
    }
}
