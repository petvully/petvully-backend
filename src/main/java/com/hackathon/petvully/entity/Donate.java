package com.hackathon.petvully.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "donate")
@NoArgsConstructor
@Getter
@Setter
public class Donate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @CreatedDate
    @Column(nullable = false)
    private LocalDate donateDate;

    @Column(nullable = false)
    private String product;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String shelter;

    @PrePersist
    public void prePersist(){
        donateDate = LocalDate.now();
    }

    @Builder
    public Donate(User userId, String product, Long price, String category, String shelter) {
        this.userId = userId;
        this.product = product;
        this.price = price;
        this.category = category;
        this.shelter = shelter;
    }
}
