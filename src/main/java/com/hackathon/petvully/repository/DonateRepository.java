package com.hackathon.petvully.repository;

import com.hackathon.petvully.entity.Donate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonateRepository extends JpaRepository<Donate, Long> {
}
