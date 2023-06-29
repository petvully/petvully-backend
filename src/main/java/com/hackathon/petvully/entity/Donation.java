package com.hackathon.petvully.entity;

import com.hackathon.petvully.dto.DonationDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String product;

    @Column(nullable = false)
    private long price;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(nullable = false)
    private long petId;

    public DonationDTO toDTO() {
        return DonationDTO.builder()
                .product(this.product)
                .price(this.price)
//                .userDTO(this.user.toDTO())
                .petId(this.petId)
                .build();
    }
}
