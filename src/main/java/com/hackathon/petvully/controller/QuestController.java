package com.hackathon.petvully.controller;

import com.hackathon.petvully.dto.QuestDTO.QuestGiveDTO;
import com.hackathon.petvully.entity.Quest;
import com.hackathon.petvully.entity.User;
import com.hackathon.petvully.repository.UserRepository;
import com.hackathon.petvully.service.QuestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "quest", description = "퀘스트 API")
@RestController
@RequestMapping("quests")
@CrossOrigin(origins = "*")
public class QuestController {

    @Autowired
    private QuestService questService;

    @Autowired
    private UserRepository userRepository;

    @Operation(summary = "", description = "물주기 API")
    @PostMapping("/give-water")
    public ResponseEntity<User> giveWater(@RequestBody QuestGiveDTO questGiveDTO) {
        User user = userRepository.findById(questGiveDTO.getUserId()).orElseThrow();
        if(questService.giveWater(questGiveDTO.getUserId())) {
            return ResponseEntity.ok(user);
        }
        else {
            return ResponseEntity.status(400).body(user);
        }
    }

    @Operation(summary = "", description = "밥주기 API")
    @PostMapping("/give-food")
    public ResponseEntity<User> giveFood(@RequestBody QuestGiveDTO questGiveDTO) {
        User user = userRepository.findById(questGiveDTO.getUserId()).orElseThrow();
        if(questService.giveFood(questGiveDTO.getUserId())) {
            return ResponseEntity.ok(user);
        }
        else {
            return ResponseEntity.status(400).body(user);
        }
    }

    @Operation(summary = "", description = "산책하기 API")
    @PostMapping("/give-walk")
    public ResponseEntity<User> giveWalk(@RequestBody QuestGiveDTO questGiveDTO) {
        User user = userRepository.findById(questGiveDTO.getUserId()).orElseThrow();
        if(questService.giveWalk(questGiveDTO.getUserId())) {
            return ResponseEntity.ok(user);
        }
        else {
            return ResponseEntity.status(400).body(user);
        }
    }

    @Operation(summary = "", description = "씻기기 API")
    @PostMapping("/give-shower")
    public ResponseEntity<User> giveShower(@RequestBody QuestGiveDTO questGiveDTO) {
        User user = userRepository.findById(questGiveDTO.getUserId()).orElseThrow();
        if(questService.giveShower(questGiveDTO.getUserId())) {
            return ResponseEntity.ok(user);
        }
        else {
            return ResponseEntity.status(400).body(user);
        }
    }

    @Operation(summary = "", description = "Quest 정보 API")
    @GetMapping("/info/{user_id}")
    public List<Quest> questInfo(@PathVariable Long user_id) {
        return questService.info(user_id);
    }
}
