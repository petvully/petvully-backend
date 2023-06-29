package com.hackathon.petvully.dto.UserDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDTO {
    private String email;
    private String password;
    private String phone;
    private String nickname;
    private Long level;
    private Long heart;
}
