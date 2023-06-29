package com.hackathon.petvully.service;

import com.hackathon.petvully.dto.UserDTO.SignUpDTO;
import com.hackathon.petvully.entity.User;
import com.hackathon.petvully.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void join(SignUpDTO signUpDTO) {
        userRepository.save(signUpDTO.toEntity());
    }

    public boolean isEmailDuplicate(String email) {
        User findUser = userRepository.findByEmail(email);
        return findUser != null;
    }
}