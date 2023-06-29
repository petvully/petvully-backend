package com.hackathon.petvully.dto;

import com.hackathon.petvully.dto.UserDTO.UserDTO;
import com.hackathon.petvully.entity.Pet;
import com.hackathon.petvully.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PetDTO {

//    private long id;
    private String email;
    private String name;
    private String image;
    private String shelter;
    private String kind;
    private long age;
    private String feature;

    public Pet toEntity(User user) {
        return Pet.builder()
                .user(user)
                .name(this.name)
                .image(this.image)
                .shelter(this.shelter)
                .kind(this.kind)
                .age(this.age)
                .feature(this.feature)
                .build();
    }
}
