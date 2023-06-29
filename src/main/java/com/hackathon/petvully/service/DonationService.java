package com.hackathon.petvully.service;

import com.hackathon.petvully.dto.DonationDTO;
import com.hackathon.petvully.entity.Donation;
import com.hackathon.petvully.repository.DonationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DonationService {
    private final DonationRepository donationRepository;

    @Transactional
    public Donation create(DonationDTO donationDTO) {
        return donationRepository.save(donationDTO.toEntity());
    }

    @Transactional
    public List<DonationDTO> findAllByUserId(long id) {
        return donationRepository.findAllByUserId(id).stream().map(Donation::toDTO).collect(Collectors.toList());
    }

    @Transactional
    public List<DonationDTO> findAllByPetId(long id) {
        return donationRepository.findAllByPetId(id).stream().map(Donation::toDTO).collect(Collectors.toList());
    }
}
