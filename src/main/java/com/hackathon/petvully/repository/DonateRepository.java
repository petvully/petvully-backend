package com.hackathon.petvully.repository;

import com.hackathon.petvully.entity.Donate;
import com.hackathon.petvully.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonateRepository extends JpaRepository<Donate, Long> {
    List<Donate> findByUserId(User user);
}
