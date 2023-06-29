package com.hackathon.petvully.dto.UserDTO;

import com.hackathon.petvully.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String email;
    private String password;
    private String phone;
    private String nickname;
    private Long level;
    private Long heart;

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .phone(phone)
                .nickname(nickname)
                .level(level)
                .heart(heart)
                .build();
    }
}
