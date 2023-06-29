package com.hackathon.petvully.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pet")
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
}
