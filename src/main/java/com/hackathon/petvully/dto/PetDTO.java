package com.hackathon.petvully.dto;

import com.hackathon.petvully.entity.Pet;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PetDTO {
    private long id;

    private String image;

    private String shelter;

    private String kind;

    private long age;

    private String character;

    public Pet toEntity() {
        return Pet.builder()
                .image(this.image)
                .shelter(this.shelter)
                .kind(this.kind)
                .age(this.age)
                .character(this.character)
                .build();
    }
}
