package com.hackathon.petvully.service;

import com.hackathon.petvully.dto.QuestDTO.QuestSaveDTO;
import com.hackathon.petvully.entity.Quest;
import com.hackathon.petvully.entity.User;
import com.hackathon.petvully.repository.QuestRepository;
import com.hackathon.petvully.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestService {
    private final QuestRepository questRepository;
    private final UserRepository userRepository;

    LocalDate currentDate = LocalDate.now();

    public boolean giveWater(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        Quest quest = questRepository.findByQuestDate(currentDate);
        if (quest == null) {
            QuestSaveDTO questSaveDTO = new QuestSaveDTO();
            questRepository.save(questSaveDTO.toEntity(user.orElseThrow()));
            Quest waterquest = questRepository.findByQuestDate(currentDate);
            waterquest.setWater(true);
            return true;
        }
        if (quest.isWater()) {
            return false;
        }
        quest.setWater(true);
        return true;
    }

    public boolean giveFood(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        Quest quest = questRepository.findByQuestDate(currentDate);
        if (quest == null) {
            QuestSaveDTO questSaveDTO = new QuestSaveDTO();
            questRepository.save(questSaveDTO.toEntity(user.orElseThrow()));
            Quest foodquest = questRepository.findByQuestDate(currentDate);
            foodquest.setFood(true);
            return true;
        }
        if (quest.isFood()) {
            return false;
        }
        quest.setFood(true);
        return true;
    }

    public boolean giveWalk(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        Quest quest = questRepository.findByQuestDate(currentDate);
        if (quest == null) {
            QuestSaveDTO questSaveDTO = new QuestSaveDTO();
            questRepository.save(questSaveDTO.toEntity(user.orElseThrow()));
            Quest walkquest = questRepository.findByQuestDate(currentDate);
            walkquest.setWalk(true);
            return true;
        }
        if (quest.isWalk()) {
            return false;
        }
        quest.setWalk(true);
        return true;
    }

    public boolean giveShower(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        Quest quest = questRepository.findByQuestDate(currentDate);
        if (quest == null) {
            QuestSaveDTO questSaveDTO = new QuestSaveDTO();
            questRepository.save(questSaveDTO.toEntity(user.orElseThrow()));
            Quest showerquest = questRepository.findByQuestDate(currentDate);
            showerquest.setShower(true);
            return true;
        }
        if (quest.isShower()) {
            return false;
        }
        quest.setShower(true);
        return true;
    }

    public List<Quest> info(Long user_id) {
        Optional<User> user = userRepository.findById(user_id);
        return questRepository.findByUserId(user);
    }
}
