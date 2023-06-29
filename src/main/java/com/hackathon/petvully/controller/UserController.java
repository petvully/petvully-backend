package com.hackathon.petvully.controller;

import com.hackathon.petvully.dto.UserDTO.SignUpDTO;
import com.hackathon.petvully.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "user", description = "유저 API")
@RestController
@RequestMapping("users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "", description = "회원가입 API")
    @PostMapping("/signup")
    public ResponseEntity<String> join(@RequestBody SignUpDTO signUpDTO) {
        if(userService.isEmailDuplicate(signUpDTO.getEmail())) {
            return ResponseEntity.status(400).body("Email already exists");
        }
        userService.join(signUpDTO);
        return ResponseEntity.ok("Join Success!");
    }
}
