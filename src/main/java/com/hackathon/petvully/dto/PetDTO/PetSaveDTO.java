package com.hackathon.petvully.dto.PetDTO;

import com.hackathon.petvully.entity.Pet;
import com.hackathon.petvully.entity.Quest;
import com.hackathon.petvully.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class PetSaveDTO {
    private Long userId;
    private String name;
    private String image;
    private String kind;
    private String color;
    private Long age;
    private Long weight;
    private String feature;
    private String region;
    private String gender;

    public Pet toEntity(User userId) {
        return Pet.builder()
                .userId(userId)
                .name(name)
                .image(image)
                .kind(kind)
                .color(color)
                .age(age)
                .weight(weight)
                .feature(feature)
                .region(region)
                .gender(gender)
                .build();
    }
}
