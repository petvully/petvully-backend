package com.hackathon.petvully.repository;

import com.hackathon.petvully.entity.Quest;
import com.hackathon.petvully.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestRepository extends JpaRepository<Quest, Long> {
    Quest findByUserId(Optional<User> user);
}
