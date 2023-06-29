package com.hackathon.petvully.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "quest")
@NoArgsConstructor
@Getter
@Setter
public class Quest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @CreatedDate
    @Column(nullable = false)
    private LocalDate questDate;

    @Column(nullable = false)
    private boolean water;

    @Column(nullable = false)
    private boolean food;

    @Column(nullable = false)
    private boolean walk;

    @Column(nullable = false)
    private boolean shower;

    @PrePersist
    public void prePersist(){
        questDate = LocalDate.now();
    }

    @Builder
    public Quest(User userId, boolean water, boolean food, boolean walk, boolean shower) {
        this.userId = userId;
        this.water = water;
        this.food = food;
        this.walk = walk;
        this.shower = shower;
    }
}
