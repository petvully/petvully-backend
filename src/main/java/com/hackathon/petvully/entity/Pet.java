package com.hackathon.petvully.entity;

import com.hackathon.petvully.dto.PetDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "pet")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String shelter;

    @Column(nullable = false)
    private String kind;

    @Column(nullable = false)
    private long age;

    @Column(nullable = false)
    private String character;

    public PetDTO toDTO() {
        return PetDTO.builder()
                .id(this.getId())
                .image(this.getImage())
                .shelter(this.getShelter())
                .kind(this.getKind())
                .age(this.getAge())
                .character(this.getCharacter())
                .build();
    }
}
