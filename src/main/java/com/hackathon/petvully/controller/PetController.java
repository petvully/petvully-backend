package com.hackathon.petvully.controller;

import com.hackathon.petvully.dto.PetDTO.PetSaveDTO;
import com.hackathon.petvully.entity.Pet;
import com.hackathon.petvully.entity.User;
import com.hackathon.petvully.repository.UserRepository;
import com.hackathon.petvully.service.PetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "pet", description = "유기동물 API")
@RestController
@RequestMapping("pets")
@CrossOrigin(origins = "*")
public class PetController {
    
    @Autowired
    private PetService petService;

    @Operation(summary = "", description = "유기동물 입양 API")
    @PostMapping("/adoption")
    public ResponseEntity<String> create(@RequestBody PetSaveDTO petSaveDTO) {
        return ResponseEntity.ok(petService.create(petSaveDTO));
    }

    @Operation(summary = "", description = "유기동물 전체 정보 조회 API")
    @GetMapping("/info")
    public ResponseEntity<List<Pet>> info() {
        return ResponseEntity.ok(petService.info());
    }

    @Operation(summary = "", description = "유기동물 상세 정보 조회 API")
    @GetMapping("/info/{pet_id}")
    public ResponseEntity<Optional<Pet>> infodetail(@PathVariable Long pet_id) {
        return ResponseEntity.ok(petService.infodetail(pet_id));
    }

    @Operation(summary = "", description = "내 유기동물 정보 조회 API")
    @GetMapping("/mypet")
    public ResponseEntity<Optional<Pet>> mypet(@PathVariable Long user_id) {
        return ResponseEntity.ok(petService.mypet(user_id));
    }
}
