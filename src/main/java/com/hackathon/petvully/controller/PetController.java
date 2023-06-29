package com.hackathon.petvully.controller;

import com.hackathon.petvully.dto.PetDTO;
import com.hackathon.petvully.dto.UserDTO.LoginDTO;
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
@RequestMapping("pet")
@CrossOrigin(origins = "*")
public class PetController {
    
    @Autowired
    private PetService petService;

    @Autowired
    private UserRepository userRepository;

    @Operation(summary = "", description = "유기동물 조회 API")
    @PostMapping("")
    public PetDTO read(@RequestBody LoginDTO loginDTO) {
        User user = userRepository.findByEmail(loginDTO.getEmail());
        return petService.findById(user.getPet().getId()).toDTO();
    }

    @Operation(summary = "", description = "유기동물 삭제 API")
    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody PetDTO petDTO) {
        Pet pet = petService.findById(petDTO.getId());
        petService.delete(pet);
        return ResponseEntity.ok("Delete Success!");
    }
}
