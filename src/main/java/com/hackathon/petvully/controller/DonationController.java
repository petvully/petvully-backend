package com.hackathon.petvully.controller;

import com.hackathon.petvully.dto.DonationDTO;
import com.hackathon.petvully.dto.UserDTO.LoginDTO;
import com.hackathon.petvully.repository.UserRepository;
import com.hackathon.petvully.service.DonationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "donation", description = "기부 API")
@RestController
@RequestMapping("donations")
@CrossOrigin(origins = "*")
public class DonationController {

    @Autowired
    private DonationService donationService;

    @Autowired
    private UserRepository userRepository;

    @Operation(summary = "", description = "회원 기부내역 조회 API")
    @PostMapping("")
    public List<DonationDTO> readByUser(@RequestBody LoginDTO loginDTO) {
        return donationService.findAllByUserId(userRepository.findByEmail(loginDTO.getEmail()).getId());
    }
}
