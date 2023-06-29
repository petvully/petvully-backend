package com.hackathon.petvully.service;

import com.hackathon.petvully.dto.QuestDTO.QuestSaveDTO;
import com.hackathon.petvully.entity.Quest;
import com.hackathon.petvully.entity.User;
import com.hackathon.petvully.repository.QuestRepository;
import com.hackathon.petvully.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestService {
    private final QuestRepository questRepository;
    private final UserRepository userRepository;

    public boolean giveWater(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        Quest quest = questRepository.findByUserId(user);
        if (quest == null) {
            QuestSaveDTO questSaveDTO = new QuestSaveDTO();
            questRepository.save(questSaveDTO.toEntity(user.orElseThrow()));
            Quest waterquest = questRepository.findByUserId(user);
            waterquest.setWater(true);
            return true;
        }
        Quest waterquest = questRepository.findByUserId(user);
        waterquest.setWater(true);
        return true;
    }

    public boolean giveFood(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        Quest quest = questRepository.findByUserId(user);
        if (quest == null) {
            QuestSaveDTO questSaveDTO = new QuestSaveDTO();
            questRepository.save(questSaveDTO.toEntity(user.orElseThrow()));
            Quest foodquest = questRepository.findByUserId(user);
            foodquest.setFood(true);
            return true;
        }
        Quest foodquest = questRepository.findByUserId(user);
        foodquest.setFood(true);
        return true;
    }
}
