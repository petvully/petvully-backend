package com.hackathon.petvully.controller;

import com.hackathon.petvully.dto.QuestDTO.QuestGiveDTO;
import com.hackathon.petvully.service.QuestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "quest", description = "퀘스트 API")
@RestController
@RequestMapping("quests")
@CrossOrigin(origins = "*")
public class QuestController {

    @Autowired
    private QuestService questService;

    @Operation(summary = "", description = "물주기 API")
    @PostMapping("/give-water")
    public ResponseEntity<String> giveWater(@RequestBody QuestGiveDTO questGiveDTO) {
        if(questService.giveWater(questGiveDTO.getUserId())) {
            return ResponseEntity.ok("물주기 완료");
        }
        else {
            return ResponseEntity.status(400).body("동물에게 관심을 주세요");
        }
    }

    @Operation(summary = "", description = "밥주기 API")
    @PostMapping("/give-food")
    public ResponseEntity<String> giveFood(@RequestBody QuestGiveDTO questGiveDTO) {
        if(questService.giveFood(questGiveDTO.getUserId())) {
            return ResponseEntity.ok("밥주기 완료");
        }
        else {
            return ResponseEntity.status(400).body("동물에게 관심을 주세요");
        }
    }

    @Operation(summary = "", description = "산책하기 API")
    @PostMapping("/give-walk")
    public ResponseEntity<String> giveWalk(@RequestBody QuestGiveDTO questGiveDTO) {
        if(questService.giveWalk(questGiveDTO.getUserId())) {
            return ResponseEntity.ok("산책하기 완료");
        }
        else {
            return ResponseEntity.status(400).body("동물에게 관심을 주세요");
        }
    }

    @Operation(summary = "", description = "씻기기 API")
    @PostMapping("/give-shower")
    public ResponseEntity<String> giveShower(@RequestBody QuestGiveDTO questGiveDTO) {
        if(questService.giveShower(questGiveDTO.getUserId())) {
            return ResponseEntity.ok("씻기기 완료");
        }
        else {
            return ResponseEntity.status(400).body("동물에게 관심을 주세요");
        }
    }
}