package com.hackathon.petvully.entity;

import com.hackathon.petvully.dto.UserDTO.UserUpdateDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private Long level;

    @Column(nullable = false)
    private Long heart;

    @Column(nullable = false)
    private boolean water;

    @Column(nullable = false)
    private boolean food;

    @Column(nullable = false)
    private boolean walk;

    @Column(nullable = false)
    private boolean shower;

    @Builder
    public User(String email, String password, String phone, String nickname, Long level, Long heart, boolean water, boolean food, boolean walk, boolean shower) {
        this.email = email;
        this.password = cryptopassword(password);
        this.phone = phone;
        this.nickname = nickname;
        this.level = level;
        this.heart = heart;
        this.water = water;
        this.food = food;
        this.walk = walk;
        this.shower = shower;
    }

    public String cryptopassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        return encodedPassword;
    }

    public void update(UserUpdateDTO userUpdateDTO) {
        this.email = userUpdateDTO.getEmail();
        this.password = cryptopassword(userUpdateDTO.getPassword());
        this.phone = userUpdateDTO.getPhone();
        this.nickname = userUpdateDTO.getNickname();
        this.level = userUpdateDTO.getLevel();
        this.heart = userUpdateDTO.getHeart();
        this.water = userUpdateDTO.isWater();
        this.food = userUpdateDTO.isFood();
        this.walk = userUpdateDTO.isWalk();
        this.shower = userUpdateDTO.isShower();
    }

}
