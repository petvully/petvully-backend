package com.hackathon.petvully.controller;

import com.hackathon.petvully.dto.DonateDTO.DonateSaveDTO;
import com.hackathon.petvully.entity.Donate;
import com.hackathon.petvully.service.DonateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "donate", description = "기부 API")
@RestController
@RequestMapping("donates")
@CrossOrigin(origins = "*")
public class DonateController {

    @Autowired
    private DonateService donateService;

    @Operation(summary = "", description = "기부하기 API")
    @PostMapping("/register")
    public ResponseEntity<Donate> registDonate(@RequestBody DonateSaveDTO donateSaveDTO) {
        return donateService.register(donateSaveDTO);
    }

    @Operation(summary = "", description = "기부하기 API")
    @GetMapping("/list/{user_id}")
    public List<Donate> listDonate(@PathVariable Long user_id) {
        return donateService.listDonate(user_id);
    }
}
