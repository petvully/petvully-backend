package com.hackathon.petvully.entity;

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
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String kind;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private Long age;

    @Column(nullable = false)
    private Long weight;

    @Column(nullable = false)
    private String feature;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private String gender;

    @Builder
    public Pet(User userId, String name, String image, String kind, String color, Long age, Long weight, String feature, String region, String gender) {
        this.userId = userId;
        this.name = name;
        this.image = image;
        this.kind = kind;
        this.color = color;
        this.age = age;
        this.weight = weight;
        this.feature = feature;
        this.region = region;
        this.gender = gender;
    }
}
