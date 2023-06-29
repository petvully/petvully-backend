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
        User user = userRepository.findById(userId).orElseThrow();
        Quest quest = questRepository.findByQuestDate(currentDate);
        if (quest == null) {
            QuestSaveDTO questSaveDTO = new QuestSaveDTO();
            questRepository.save(questSaveDTO.toEntity(user));
            Quest waterquest = questRepository.findByQuestDate(currentDate);
            waterquest.setWater(true);
            user.setExp(user.getExp()+20);
            if (user.getExp() == 100) {
                user.setLevel(user.getLevel()+1);
                user.setExp(0L);
            }
            return true;
        }
        if (quest.isWater()) {
            return false;
        }
        quest.setWater(true);
        user.setExp(user.getExp()+20);
        if (user.getExp() == 100) {
            user.setLevel(user.getLevel()+1);
            user.setExp(0L);
        }
        return true;
    }

    public boolean giveFood(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        Quest quest = questRepository.findByQuestDate(currentDate);
        if (quest == null) {
            QuestSaveDTO questSaveDTO = new QuestSaveDTO();
            questRepository.save(questSaveDTO.toEntity(user));
            Quest foodquest = questRepository.findByQuestDate(currentDate);
            foodquest.setFood(true);
            user.setExp(user.getExp()+20);
            if (user.getExp() == 100) {
                user.setLevel(user.getLevel()+1);
                user.setExp(0L);
            }
            return true;
        }
        if (quest.isFood()) {
            return false;
        }
        quest.setFood(true);
        user.setExp(user.getExp()+20);
        if (user.getExp() == 100) {
            user.setLevel(user.getLevel()+1);
            user.setExp(0L);
        }
        return true;
    }

    public boolean giveWalk(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        Quest quest = questRepository.findByQuestDate(currentDate);
        if (quest == null) {
            QuestSaveDTO questSaveDTO = new QuestSaveDTO();
            questRepository.save(questSaveDTO.toEntity(user));
            Quest walkquest = questRepository.findByQuestDate(currentDate);
            walkquest.setWalk(true);
            user.setExp(user.getExp()+20);
            if (user.getExp() == 100) {
                user.setLevel(user.getLevel()+1);
                user.setExp(0L);
            }
            return true;
        }
        if (quest.isWalk()) {
            return false;
        }
        quest.setWalk(true);
        user.setExp(user.getExp()+20);
        if (user.getExp() == 100) {
            user.setLevel(user.getLevel()+1);
            user.setExp(0L);
        }
        return true;
    }

    public boolean giveShower(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        Quest quest = questRepository.findByQuestDate(currentDate);
        if (quest == null) {
            QuestSaveDTO questSaveDTO = new QuestSaveDTO();
            questRepository.save(questSaveDTO.toEntity(user));
            Quest showerquest = questRepository.findByQuestDate(currentDate);
            showerquest.setShower(true);
            user.setExp(user.getExp()+20);
            if (user.getExp() == 100) {
                user.setLevel(user.getLevel()+1);
                user.setExp(0L);
            }
            return true;
        }
        if (quest.isShower()) {
            return false;
        }
        quest.setShower(true);
        user.setExp(user.getExp()+20);
        if (user.getExp() == 100) {
            user.setLevel(user.getLevel()+1);
            user.setExp(0L);
        }
        return true;
    }

    public List<Quest> info(Long user_id) {
        Optional<User> user = userRepository.findById(user_id);
        return questRepository.findByUserId(user);
    }
}
