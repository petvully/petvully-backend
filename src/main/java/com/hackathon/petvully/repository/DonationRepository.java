package com.hackathon.petvully.repository;

import com.hackathon.petvully.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Long> {
    List<Donation> findAllByUserId(long user_id);

    List<Donation> findAllByPetId(long pet_id);
}
