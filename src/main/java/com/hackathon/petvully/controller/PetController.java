package com.hackathon.petvully.controller;

import com.hackathon.petvully.dto.PetDTO;
import com.hackathon.petvully.dto.UserDTO.LoginDTO;
import com.hackathon.petvully.dto.UserDTO.UserDTO;
import com.hackathon.petvully.entity.Pet;
import com.hackathon.petvully.entity.User;
import com.hackathon.petvully.repository.UserRepository;
import com.hackathon.petvully.service.PetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "pet", description = "유기동물 API")
@RestController
@RequestMapping("mypet")
@CrossOrigin(origins = "*")
public class PetController {
    
    @Autowired
    private PetService petService;

    @Autowired
    private UserRepository userRepository;

    @Operation(summary = "", description = "유기동물 입양 API")
    @PostMapping("/adoption")
    public ResponseEntity<String> create(@RequestBody PetDTO petDTO) {
        petService.create(petDTO);
        return ResponseEntity.ok("입양을 축하합니다!");
    }
    
    @Operation(summary = "", description = "유기동물 조회 API")
    @PostMapping("")
    public Pet read(@RequestBody UserDTO UserDTO) {
        User user = userRepository.findByEmail(UserDTO.getEmail());
        return petService.findByUserId(user.getId());
    }

    @Operation(summary = "", description = "유기동물 갱신 API")
    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody PetDTO petDTO) {
        petService.update(petDTO);
        return ResponseEntity.ok("입양을 축하합니다!");
    }

    @Operation(summary = "", description = "유기동물 삭제 API")
    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody PetDTO petDTO) {
        Pet pet = petService.findById(userRepository.findByEmail(petDTO.getEmail()).getId());
        petService.delete(pet);
        return ResponseEntity.ok("Delete Success!");
    }
}
