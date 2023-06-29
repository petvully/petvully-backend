package com.hackathon.petvully.controller;

import com.hackathon.petvully.dto.UserDTO.EmailDupDTO;
import com.hackathon.petvully.dto.UserDTO.LoginDTO;
import com.hackathon.petvully.dto.UserDTO.SignUpDTO;
import com.hackathon.petvully.entity.User;
import com.hackathon.petvully.repository.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

    @Operation(summary = "", description = "회원가입 API")
    @PostMapping("/signup")
    public ResponseEntity<String> join(@RequestBody SignUpDTO signUpDTO) {
        if (userService.isEmailDuplicate(signUpDTO.getEmail())) {
            return ResponseEntity.status(400).body("Email already exists");
        }
        userService.join(signUpDTO);
        return ResponseEntity.ok("Join Success!");
    }

    @Operation(summary = "", description = "이메일 중복 확인 API")
    @PostMapping("/emailDup")
    public ResponseEntity<String> emailDup(@RequestBody EmailDupDTO email) {
        if (userService.isEmailDuplicate(email.getEmail())) {
            return ResponseEntity.status(400).body("Email already exists");
        }
        return ResponseEntity.ok("You can signup");
    }
    @Operation(summary = "", description = "로그인 API")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        if(userService.isEmailDuplicate(loginDTO.getEmail())) {
            if(userService.comparePassword(loginDTO.getEmail(),loginDTO.getPassword())) {
                User user = userRepository.findByEmail(loginDTO.getEmail());
                if(user != null) {
                    return ResponseEntity.ok("로그인 완료");
                }
                return ResponseEntity.status(400).body("사용자를 찾을 수 없습니다.");
            }
            return ResponseEntity.status(400).body("비밀번호가 틀렸습니다.");
        }
        return ResponseEntity.status(400).body("사용자를 찾을 수 없습니다.");
    }
}
